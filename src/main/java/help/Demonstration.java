package help;

import Entity.DemonstrationEntity;
import Entity.PersonGoToDiEntity;
import jakarta.persistence.TypedQuery;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Demonstration extends jpaHelp{
    /*
   Demonstration.insert(subject , Micoom );
    */
    public static void insert(String subject , String Micoom ){
        LocalDate myObj = LocalDate.now();
        DemonstrationEntity data=new DemonstrationEntity();
        data.setSubject(subject);
        data.setMicoom(Micoom);
        data.setDateOfDis(Date.valueOf(myObj));
        entityManager.persist(data);
    }
    /*
    List<DemonstrationEntity> list=Demonstration.select();
     */
    public static List<DemonstrationEntity> select(){
        TypedQuery<DemonstrationEntity> query = entityManager.createQuery(
                "SELECT e FROM DemonstrationEntity e", DemonstrationEntity.class);
        List<DemonstrationEntity> resultList = query.getResultList();
        return resultList;
    }
    /*
    Demonstration.printTable();
     */
    public static void printTable(){
        List<DemonstrationEntity> list = select();
        for (DemonstrationEntity i:list) {
            System.out.println(i);
        }
    }
    /*
    Demonstration.updateUser(new DemonstrationEntity());
     */
    public static void updateUser(DemonstrationEntity data){
        DemonstrationEntity tmp = entityManager.find(DemonstrationEntity.class, data.getId());
        tmp.setSubject(data.getSubject());
        tmp.setMicoom(data.getMicoom());
        tmp.setDateOfDis(data.getDateOfDis());
        entityManager.merge(tmp);
    }

}
