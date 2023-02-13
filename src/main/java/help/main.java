package help;

import Entity.DemonstrationEntity;
import Entity.PersonGoToDiEntity;
import Entity.PersonalDetailsEntity;
import help.Demonstration;
import help.PersonGoToDi;
import help.PersonalDetails;
import help.jpaHelp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

//        jpaHelp p = new jpaHelp();
//        p.upConnect();
//        PersonalDetails.insert("nave2","yadai2","05422333");
//        p.closeConnect();

        control();



    }
    public static void control(){
        int tmp;
        jpaHelp p = new jpaHelp();
        p.upConnect();
        while (true){
            PrintInstructions();
            tmp=in.nextInt();
            switch (tmp) {
                case 1:
                    insertPeopleToDB();
                    break;
                case 2:
                    insertDis();
                    break;
                case 3:
                    getAllOfPeopleThatGoingThisDes();
                    break;
                case 4:
                    addPeopleForDes();
                    break;
                default:
                    p.closeConnect();
                    return;
            }
        }
    }
    private static void addPeopleForDes() {
        int idDemo=findIdDem();
        int idPerDis= findIdPersonalDials();
        if( idPerDis == -1 || idDemo == -1 ){
            printError(idPerDis,idDemo);
            return;
        }
        PersonGoToDi.insert(idPerDis , idDemo);
    }
    public static void printError(int idPerDis , int idDemo){
        if( idPerDis == -1 && idDemo == -1 ){
            System.out.printf("If everything you put in is a mistake why are you wasting it on me cpu");
            return;
        }
        if( idPerDis == -1 && idDemo != -1 ){
            System.out.printf("error in personalDitals");
            return;
        }
        System.out.printf("error in Dem");
    }
    public static int findIdPersonalDials() {
        List<PersonalDetailsEntity> list=PersonalDetails.select();
        System.out.print("enter your first Name");
        String fName=in.next();
        System.out.printf("enter your last Name");
        String lName=in.next();
        for (PersonalDetailsEntity i:list) {
            if (fName.equals(i.getFirstName()) && lName.equals(i.getLastName())) {
                return i.getId();
            }
        }
        return -1;
    }
    private static void getAllOfPeopleThatGoingThisDes() {
        List<PersonGoToDiEntity> listPersonGoToDi=PersonGoToDi.select();
        int id = findIdDem();
        if(id == -1){
            System.out.println("we not find this demonstration");
            return;
        }
        for (PersonGoToDiEntity i :listPersonGoToDi) {
            if(i.getIdDemons() == id){
                PersonalDetailsEntity tmp ;
                tmp = PersonalDetails.getPepoleFromId(id);
                if (tmp != null){
                    System.out.println(tmp);
                }
            }
        }
    }
    public static int findIdDem(){
        List<DemonstrationEntity> listDemonstration=Demonstration.select();
        System.out.print("enter name of demonstration");
        String name=in.next();
        for (DemonstrationEntity i:listDemonstration) {
             if(name.equals(i.getSubject())){
                 return i.getId();
             }
        }
        return -1;
    }
    private static void insertDis() {
        DemonstrationEntity data=createDemonsForInsert();
        Demonstration.insert(data.getSubject(), data.getMicoom());
    }
    public static DemonstrationEntity createDemonsForInsert(){
        System.out.print("enter subject :");
        String subject=in.next();
        System.out.printf("\nenter micoom :");
        String micoom=in.next();
        DemonstrationEntity data
            =new DemonstrationEntity(subject,micoom);
        return data;
    }
    private static void insertPeopleToDB() {
        PersonalDetailsEntity data = createAnd();
        PersonalDetails.insert
                (data.getFirstName(), data.getLastName(), data.getPhone());
    }
    public static PersonalDetailsEntity createAnd(){
        System.out.println("enter a first Name");
        String fName=in.next();
        System.out.println("enter a last Name");
        String lName=in.next();
        System.out.println("enter a phone");
        String phone=in.next();
        PersonalDetailsEntity data
                = new PersonalDetailsEntity(fName,lName,phone);
        return data;
    }
    public static void PrintInstructions(){
        System.out.println("enter num befur anderstend what  douning");
        System.out.println("1 to insert pepole to DB \n2 to insert Demonstration to DB");
        System.out.println("3 to find all pepole in Demonstration\n4 to add pepole to Demonstration");
        System.out.println("and oder to close connect and out\n");
    }
}
