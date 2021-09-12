$(function(){

    const appendBook = function(data){
        var bookCode = '<a href="#" class="book-link" data-id="' +
            data.id + '">' + data.name + '</a><br>';
        $('#book-list')
            .append('<div>' + bookCode + '</div>');
    };

    //Loading books on load page
    $.get('/notes/', function(response)
    {
        for(i in response) {
            appendBook(response[i]);
        }
    });

    //Show adding book form
    $('#show-add-book-form').click(function(){
        $('#book-form').css('display', 'flex');
    });

    //Closing adding book form
    $('#book-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Getting book
    $(document).on('click', '.book-link', function(){
        var link = $(this);
        var bookId = link.data('id');
        $.ajax({
            method: "GET",
            url: '/notes/' + bookId,
            success: function(response)
            {
                var code = '<span>Вот эта запись  + '</span>';
                link.parent().append(code);
            },
            error: function(response)
            {
                if(response.status == 404) {
                    alert('такой записи нет');
                }
            }
        });
        return false;
    });

    //Adding book
    $('#save-book').click(function()
    {
        var data = $('#book-form form').serialize();
        $.ajax({
            method: "POST",
            url: '/notes/',
            data: data,
            success: function(response)
            {
                $('#book-form').css('display', 'none');
                var book = {};
                book.id = response;
                var dataArray = $('#book-form form').serializeArray();
                for(i in dataArray) {
                    book[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendBook(book);
            }
        });
        return false;
    });



//    $('#delete-books').click(function()
//    {
//        var data = $('#book-form form').serialize();
//                $.ajax({
//                    method: "DELETE",
//                    url: '/notes/',
//                    data: data,
//                    success: function(response)
//                    {
//
//                    }
//                });
//                return false;
//    });
//    });





    $(document).on('click', '.delete-books', function()
        {
            var data = $('#book-form form').serialize();
            $.ajax({
               method: "DELETE",
               url: '/notes/',
               data: data,
              success: function(response)
               {
                  $('#book-form').css('display', 'none');
                   var book = {};
                   book.id = response;
                    var dataArray = $('#book-form form').serializeArray();
                   int k = 0;
                   for(i in dataArray) {
                        book[dataArray[i]['name']] = dataArray[i]['value'];
                        k = i;
                  }
                 book.splice(1,k);
              }
            });
           return false;
        });

});