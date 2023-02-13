package help;

import Entity.PersonGoToDiEntity;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PersonGoToDi extends jpaHelp{
    /*
    PersonGoToDi.insert(idDit , idDe);
     */
    public static void insert(int idDitels  , int idDe){
        PersonGoToDiEntity data=new PersonGoToDiEntity();
        data.setIdPersonalDitels(idDitels);
        data.setIdDemons(idDe);
        entityManager.persist(data);
    }
    /*
    list=PersonGoToDi.select();
     */
    public static List<PersonGoToDiEntity> select(){
        TypedQuery<PersonGoToDiEntity> query = entityManager.createQuery(
                "SELECT e FROM PersonGoToDiEntity e", PersonGoToDiEntity.class);
        List<PersonGoToDiEntity> resultList = query.getResultList();
        return resultList;
    }
    /*
    PersonGoToDi.printTable();
     */
    public static void printTable(){
        List<PersonGoToDiEntity> list = select();
        for (PersonGoToDiEntity i:list) {
            System.out.println(i);
        }
    }
    /*
    PersonGoToDi.updateUser(new PersonGoToDiEntity(4,1,1));
     */
    public static void updateUser(PersonGoToDiEntity data){
        PersonGoToDiEntity tmp = entityManager.find(PersonGoToDiEntity.class, data.getId());
        tmp.setIdPersonalDitels(data.getIdPersonalDitels());
        tmp.setIdDemons(data.getIdDemons());
        entityManager.merge(tmp);

    }
}
