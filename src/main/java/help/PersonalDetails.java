package help;

import Entity.PersonGoToDiEntity;
import Entity.PersonalDetailsEntity;
import jakarta.persistence.TypedQuery;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class PersonalDetails extends jpaHelp{
    /*
    PersonalDetails.insert(fName , lName , phone);
     */
    public static void insert(String fName , String lName , String phone ){
        PersonalDetailsEntity ddd=new PersonalDetailsEntity();
        LocalDate myObj = LocalDate.now();
        ddd.setFirstName(fName);
        ddd.setLastName(lName);
        ddd.setPhone(phone);
        ddd.setDateOfBirth(Date.valueOf(myObj));
        entityManager.persist(ddd);
    }
    /*
    list=PersonalDetails.select();
     */
    public static List<PersonalDetailsEntity> select(){
        TypedQuery<PersonalDetailsEntity> query = entityManager.createQuery(
                "SELECT e FROM PersonalDetailsEntity e", PersonalDetailsEntity.class);
        List<PersonalDetailsEntity> resultList = query.getResultList();
        return resultList;
    }
    /*
    PersonalDetails.printTable();
     */
    public static void printTable(){
        List<PersonalDetailsEntity> list = select();
        for (PersonalDetailsEntity i:list) {
            System.out.println(i);
        }
    }
    /*
    PersonalDetails.updateUser(new PersonalDetailsEntity());
     */
    public static void updateUser(PersonalDetailsEntity data){
        PersonalDetailsEntity tmp = entityManager.find(PersonalDetailsEntity.class, data.getId());
        LocalDate myObj = LocalDate.now();
        tmp.setFirstName(data.getFirstName());
        tmp.setLastName(data.getLastName());
        tmp.setPhone(data.getPhone());
        tmp.setDateOfBirth(Date.valueOf(myObj));
        entityManager.merge(tmp);

    }
    /*
    PersonalDetailsEntity tmp = PersonalDetails.getPepoleFromId(id);
     */
    public static PersonalDetailsEntity getPepoleFromId(int id){
        PersonalDetailsEntity tmp;
        tmp = entityManager.find(PersonalDetailsEntity.class, id);
        return tmp;
    }
}
