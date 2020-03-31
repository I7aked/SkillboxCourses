public class Second {
        public static void main(String[] args) {

            Float[] temperaturePations = new Float[30] ;
            float srednyaTemperatura = 0;
            int zdoroviyPations = 0;
        for (int i = 0; i < 30; i++)
        {
            temperaturePations[i] = (float)Math.round((32 + 8*Math.random())*10)/10;
            System.out.print(temperaturePations[i] + " ");
            srednyaTemperatura = srednyaTemperatura + temperaturePations[i];
            if (temperaturePations[i]>=36.2 && temperaturePations[i]<=36.9)
            {
                zdoroviyPations ++;
            }
        }
            System.out.println();
//            for (int i = 0; i < 30; i++)
//            {
//                System.out.print(temperaturePations[i] + " ");
//                srednyaTemperatura = srednyaTemperatura + temperaturePations[i];
//            }

            System.out.println("Средняя температура по больнице ="+ (float)(Math.round(srednyaTemperatura/3))/10);
            System.out.println("Количество здоровых пациентов = "+ zdoroviyPations);


        }
    }


