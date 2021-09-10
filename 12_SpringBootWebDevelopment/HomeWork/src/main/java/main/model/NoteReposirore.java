package main.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteReposirore extends CrudRepository <Note,Integer>
{
}
