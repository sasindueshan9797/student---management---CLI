import java.util.*;

class Main {
    public static String studentID[] = {};
    public static String studentName[] = {};
    public static int studentPRFMarks[] = {};
    public static int studentDBMSMarks[] = {};
    public static int studentTotalMarks[] = {};
    public static double studentAverage[] = {};

    public static void main(String[] args) {
        menu();
    }

    // ===========MAIN MENU==========================================
    public static void menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM");
        System.out.println("\n[1]Add New Student\t\t\t[2]Add New Student With Marks");
        System.out.println("[3]Add Marks\t\t\t\t[4]Update Student Details");
        System.out.println("[5]Update Marks\t\t\t\t[6]Delete Student");
        System.out.println("[7]Print Student Detail\t\t\t[8]Print Student Ranks");
        System.out.println("[9]Best in Programming Fundamentals\t[10]Best in Database Management System");

        System.out.print("\nEnter Option to Continue: ");
        int option = input.nextInt();
        clearConsole();
        switch (option) {
            case 1:
                addNewStudent();
                break;
            case 2:
                addNewStudentWithMarks();
                break;
            case 3:
                addMarks();
                break;
            case 4:
                updateDetails();
                break;
            case 5:
                updateMarks();
                break;
            case 6:
                deleteStudent();
                break;
            case 7:
                printStudentDetails();
                break;
            case 8:
                printstudentRanks();
                break;
            case 9:
                bestInPRF();
                break;
            case 10:
                bestInDBMS();
                break;
            default:
                System.out.println("Invalid input");
                return;
        }
    }
    // ===========MAIN MENU==========================================

    public static boolean isStudentIDExists(String id) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < studentID.length; i++) {
            if (studentID[i].equals(id)) {
                return true;
            }
        }
        return false;
    }

    // ===========ADD NEW STUDENT====================================
    public static void addNewStudent() {
        System.out.println("\t\tADD NEW STUDENT");
        Scanner input = new Scanner(System.in);

        boolean flag = true;

        while (flag) {
            String tempID[] = new String[studentID.length + 1];
            String tempName[] = new String[studentID.length + 1];
            int tempPRF[] = new int[studentID.length + 1];
            int tempDBMS[] = new int[studentID.length + 1];
            int tempTot[] = new int[studentID.length + 1];
            double tempAvg[] = new double[studentID.length + 1];
            System.out.print("\n\nEnter Student ID: ");
            String id = input.nextLine();

            boolean isStudentIDExists = isStudentIDExists(id);

            for (int i = 0; i < studentID.length; i++) {
                tempID[i] = studentID[i];
                tempName[i] = studentName[i];
                tempPRF[i] = studentPRFMarks[i];
                tempDBMS[i] = studentDBMSMarks[i];
                tempTot[i] = studentTotalMarks[i];
                tempAvg[i] = studentAverage[i];
            }

            for (int i = 0; i < tempID.length; i++) {
                if (tempID[i] != null) {
                    if (isStudentIDExists) {
                        System.out.print("The Student ID already exist");
                        break;
                    }
                } else {
                    System.out.print("Enter Student Name: ");
                    String name = input.nextLine();
                    tempID[tempID.length - 1] = id;
                    tempName[tempName.length - 1] = name;
                    studentID = tempID;
                    studentName = tempName;
                    studentPRFMarks = tempPRF;
                    studentDBMSMarks = tempDBMS;
                    studentTotalMarks = tempTot;
                    studentAverage = tempAvg;
                    System.out.print("\nStudent has been added Successfully. Do want to add a new student?(y/n): ");
                    String choice = input.nextLine();
                    if (choice.equals("y")) {
                        break;
                    } else {
                        menu();
                        flag = false;
                    }
                }
            }
        }
    }
    // ===========ADD NEW STUDENT====================================

    // ===========ADD NEW STUDENT WITH MARKS=========================
    public static void addNewStudentWithMarks() {
        System.out.println("\t\tADD NEW STUDENT WITH MARKS");

        Scanner input = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            String tempID[] = new String[studentID.length + 1];
            String tempName[] = new String[studentID.length + 1];
            System.out.print("\n\nEnter Student ID: ");
            String id = input.nextLine();
            boolean isStudentIDExists = isStudentIDExists(id);

            for (int i = 0; i < studentID.length; i++) {
                tempID[i] = studentID[i];
                tempName[i] = studentName[i];
            }

            for (int i = 0; i < tempID.length; i++) {
                if (tempID[i] != null) {
                    if (isStudentIDExists) {
                        System.out.print("The Student ID already exist");
                        break;
                    }
                } else {
                    System.out.print("Enter Student Name: ");
                    String name = input.nextLine();
                    marksCheck();
                    tempID[tempID.length - 1] = id;
                    tempName[tempName.length - 1] = name;
                    studentID = tempID;
                    studentName = tempName;
                    System.out.print(
                            "\nStudent has been added Successfully. Do want to add a new student?(y/n): ");
                    String choice = input.nextLine();
                    if (choice.equals("y")) {
                        break;
                    } else {
                        menu();
                        flag = false;
                    }
                }
            }
        }
    }

    public static void marksCheck() {
        Scanner input = new Scanner(System.in);

        int tempPRF[] = new int[studentID.length + 1];
        int tempDBMS[] = new int[studentID.length + 1];
        int tempTot[] = new int[studentID.length + 1];
        double tempAvg[] = new double[studentID.length + 1];
        int prfMarks;
        int dbmsMarks;
        boolean flag = true;

        for (int i = 0; i < studentID.length; i++) {
            tempPRF[i] = studentPRFMarks[i];
            tempDBMS[i] = studentDBMSMarks[i];
            tempTot[i] = studentTotalMarks[i];
            tempAvg[i] = studentAverage[i];
        }
        while (flag) {
            System.out.print("\nProgramming Fundamentals Marks: ");
            prfMarks = input.nextInt();
            for (int j = 0; j < tempPRF.length; j++) {
                if (prfMarks < 0 || prfMarks > 100) {
                    System.out.println("Invalid marks. Please enter correct marks");
                    break;
                } else {
                    while (flag) {
                        System.out.print("Database Management System Marks: ");
                        dbmsMarks = input.nextInt();
                        for (int k = 0; k < tempDBMS.length; k++) {
                            if (dbmsMarks < 0 || dbmsMarks > 100) {
                                System.out.println("Invalid marks. Please enter correct marks");
                                break;
                            } else {
                                tempPRF[tempPRF.length - 1] = prfMarks;
                                tempDBMS[tempDBMS.length - 1] = dbmsMarks;
                                studentPRFMarks = tempPRF;
                                studentDBMSMarks = tempDBMS;
                                studentTotalMarks = tempTot;
                                studentAverage = tempAvg;
                                flag = false;
                            }
                        }
                    }
                }
            }
        }

    }
    // ===========ADD NEW STUDENT WITh MARKS=========================

    // =======================ADD MARKS==============================
    public static void marksCheckandADD(int index) {
        Scanner input = new Scanner(System.in);

        int prfMarks;
        int dbmsMarks;
        boolean flag = true;

        while (flag) {
            System.out.print("\nProgramming Fundamentals Marks: ");
            prfMarks = input.nextInt();
            for (int j = 0; j < studentPRFMarks.length; j++) {
                if (prfMarks < 0 || prfMarks > 100) {
                    System.out.println("Invalid marks. Please enter correct marks");
                    break;
                } else {
                    while (flag) {
                        System.out.print("Database Management System Marks: ");
                        dbmsMarks = input.nextInt();
                        for (int k = 0; k < studentDBMSMarks.length; k++) {
                            if (dbmsMarks < 0 || dbmsMarks > 100) {
                                System.out.println("Invalid marks. Please enter correct marks");
                                break;
                            } else {
                                studentPRFMarks[index] = prfMarks;
                                studentDBMSMarks[index] = dbmsMarks;
                                flag = false;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void addMarks() {
        System.out.println("\t\tADD MARKS");

        Scanner input = new Scanner(System.in);
        int index = 0;
        boolean flag = true;

        while (flag) {
            System.out.print("\nEnter Student ID: ");
            String id = input.nextLine();
            boolean isStudentIDExists = isStudentIDExists(id);

            if (isStudentIDExists) {
                for (int i = 0; i < studentID.length; i++) {
                    if (studentID[i].equals(id)) {
                        if (studentPRFMarks[i] != 0) {
                            System.out.println("Student Name: " + studentName[i]);
                            System.out.println("This students marks have been already added");
                            System.out.println(
                                    "If you want to update the marks, please use [5] Update marks option in main menu");
                            System.out.print("\nDo you want to add marks for another student? (y/n): ");
                            String choice3 = input.nextLine();
                            if (choice3.equals("y")) {
                                break;
                            } else {
                                menu();
                                flag = false;
                            }
                        } else {
                            System.out.println("Student Name: " + studentName[i]);
                            index = i;
                            marksCheckandADD(index);
                            System.out
                                    .print("Marks have been added. Do you want to add marks for another student? (y/n): ");
                            String choice2 = input.nextLine();
                            if (choice2.equals("y")) {
                                break;
                            } else {
                                menu();
                                flag = false;
                            }
                        }
                    }
                }
            } else {
                System.out.print("Invalid Student ID. Do you want to search again? (y/n): ");
                String choice1 = input.nextLine();
                if (choice1.equals("y")) {
                    break;
                } else {
                    menu();
                    flag = false;
                }
            }
        }
    }
    // =======================ADD MARKS==============================

    // ===================UPDATE STUDENT DETAILS=====================
    public static void updateDetails() {
        System.out.println("\t\tUPDATE STUDENT DETAILS");

        Scanner input = new Scanner(System.in);
        boolean flag = true;
        System.out.println(Arrays.toString(studentID));
        System.out.println(Arrays.toString(studentName));

        while (flag) {
            System.out.print("\nEnter Student ID: ");
            String id = input.nextLine();

            boolean isStudentIDExists = isStudentIDExists(id);
            if (isStudentIDExists) {
                for (int i = 0; i < studentID.length; i++) {
                    if (studentID[i].equals(id)) {
                        System.out.println("Student Name: " + studentName[i]);
                        System.out.print("\nEnter the new student name: ");
                        studentName[i] = input.nextLine();
                        System.out.println("\nStudent details has been updated successfully.");
                        System.out.print("Do you want to update another student details? (y/n): ");
                        String choice2 = input.nextLine();
                        if (choice2.equals("y")) {
                            break;
                        } else {
                            menu();
                            flag = false;
                        }
                    }
                }
            } else {
                System.out.print("Invalid Student ID. Do you want to search again? (y/n): ");
                String choice1 = input.nextLine();
                if (choice1.equals("y")) {
                    break;
                } else {
                    menu();
                    flag = false;
                }
            }
        }
    }
    // ===================UPDATE STUDENT DETAILS=====================

    // =======================UPDATE MARKS===========================
    public static void updateMarks() {
        System.out.println("\t\tUPDATE MARKS");

        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.print("\nEnter Student ID: ");
            String id = input.nextLine();

            boolean isStudentIDExists = isStudentIDExists(id);
            if (isStudentIDExists) {
                for (int i = 0; i < studentID.length; i++) {
                    if (studentID[i].equals(id)) {
                        System.out.println("Student Name: " + studentName[i]);
                        if (studentPRFMarks[i] != 0) {
                            System.out.println("\nProgramming Fundamentals Marks: " + studentPRFMarks[i]
                                    + "\nDatabase Management System Marks: " + studentDBMSMarks[i]);
                            marksCheckandUpdate(i);
                            System.out.println("Marks have been updated successfully.");
                            System.out.print("Do you want to update marks for another student? (y/n): ");
                            String choice1 = input.nextLine();
                            if (choice1.equals("y")) {
                                break;
                            } else {
                                menu();
                                flag = false;
                            }
                        } else {
                            System.out.println("This student's marks yet to be added");
                            System.out.print("Do you want to update the marks of another student? (y/n): ");
                            String choice2 = input.nextLine();
                            if (choice2.equals("y")) {
                                break;
                            } else {
                                menu();
                                flag = false;
                            }
                        }
                    }
                }
            } else {
                System.out.print("Invalid Student ID. Do you want to search again? (y/n): ");
                String choice1 = input.nextLine();
                if (choice1.equals("y")) {
                    break;
                } else {
                    menu();
                    flag = false;
                }
            }
        }
    }

    public static void marksCheckandUpdate(int index) {
        Scanner input = new Scanner(System.in);
        int prfMarks;
        int dbmsMarks;
        boolean flag = true;

        while (flag) {
            System.out.print("\nEnter New Programming Fundamentals Marks: ");
            prfMarks = input.nextInt();
            for (int j = 0; j < studentPRFMarks.length; j++) {
                if (prfMarks < 0 || prfMarks > 100) {
                    System.out.println("Invalid marks. Please enter correct marks");
                    break;
                } else {
                    while (flag) {
                        System.out.print("Enter New Database Management System Marks: ");
                        dbmsMarks = input.nextInt();
                        for (int i = 0; i < studentDBMSMarks.length; i++) {
                            if (dbmsMarks < 0 || dbmsMarks > 100) {
                                System.out.println("Invalid marks. Please enter correct marks");
                                break;
                            } else {
                                studentPRFMarks[index] = prfMarks;
                                studentDBMSMarks[index] = dbmsMarks;
                                flag = false;
                            }
                        }
                    }
                }
            }
        }
    }
    // =======================UPDATE MARKS===========================

    // =======================DELETE STUDENT==========================
    public static void deleteStudent() {
        System.out.println("\t\tDELETE STUDENT");

        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.print("\n\nEnter Student ID: ");
            String id = input.nextLine();

            boolean isStudentIDExists = isStudentIDExists(id);

            if (isStudentIDExists) {
                for (int i = 0; i < studentID.length; i++) {
                    if (studentID[i].equals(id)) {
                        removeDetails(i);
                        System.out.println("Student has been deleted successfully");
                        System.out.print("Do you want to delete another student? (y/n): ");
                        String choice1 = input.nextLine();
                        if (choice1.equals("y")) {
                            break;
                        } else {
                            menu();
                            flag = false;
                        }

                    }
                }
            } else {
                System.out.print("Invalid Student ID. Do you want to search again? (y/n): ");
                String choice = input.nextLine();
                if (choice.equals("y")) {
                    break;
                } else {
                    menu();
                    flag = false;
                }
            }
        }

    }

    public static void removeDetails(int index) {
        String tempID[] = new String[studentID.length - 1];
        String tempName[] = new String[studentID.length - 1];
        int tempPRF[] = new int[studentID.length - 1];
        int tempDBMS[] = new int[studentID.length - 1];
        int tempTot[] = new int[studentID.length - 1];
        double tempAvg[] = new double[studentID.length - 1];

        for (int i = 0; i < index; i++) {
            tempID[i] = studentID[i];
            tempName[i] = studentName[i];
            tempPRF[i] = studentPRFMarks[i];
            tempDBMS[i] = studentDBMSMarks[i];
            tempTot[i] = studentTotalMarks[i];
            tempAvg[i] = studentAverage[i];
        }
        for (int i = index; i < tempID.length; i++) {
            tempID[i] = studentID[i + 1];
            tempName[i] = studentName[i + 1];
            tempPRF[i] = studentPRFMarks[i + 1];
            tempDBMS[i] = studentDBMSMarks[i + 1];
            tempTot[i] = studentTotalMarks[i + 1];
            tempAvg[i] = studentAverage[i + 1];
        }

        studentID = tempID;
        studentName = tempName;
        studentPRFMarks = tempPRF;
        studentDBMSMarks = tempDBMS;
        tempTot = studentTotalMarks;
        tempAvg = studentAverage;
    }
    // =======================DELETE STUDENT==========================

    // =====================PRINT STUDENT DETAILS=====================
    public static void printStudentDetails() {
        System.out.println("\t\tPRINT STUDENT DETAILS");

        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.print("\n\nEnter Student ID: ");
            String id = input.nextLine();
            sortTotal();

            boolean isStudentIDExists = isStudentIDExists(id);

            if (isStudentIDExists) {
                for (int i = 0; i < studentID.length; i++) {
                    if (studentID[i].equals(id)) {
                        detailsChecknPrint(i);
                    }
                }
            } else {
                System.out.print("Invalid Student ID. Do you want to search again? (y/n): ");
                String choice = input.nextLine();
                if (choice.equals("y")) {
                    break;
                } else {
                    menu();
                    flag = false;
                }
            }
        }
    }

    public static void detailsChecknPrint(int index) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < studentID.length; i++) {
            if (studentTotalMarks[index] == 0) {
                System.out.println("Student Name: " + studentName[index]);
                System.out.println("\nMarks yet to be added");
                System.out.print("\nDo you want to search another student? (y/n): ");
                String choice = input.nextLine();
                if (choice.equals("y")) {
                    break;
                } else {
                    menu();
                    break;
                }
            } else {
                System.out.println("Student Name: " + studentName[index]);
                System.out.println("\nProgramming Fundamentals Marks: \t\t" + studentPRFMarks[index]);
                System.out.println("Programming Fundamentals Marks: \t\t" + studentDBMSMarks[index]);
                System.out.println("Total Marks: \t\t\t\t\t" + (studentDBMSMarks[index] + studentPRFMarks[index]));
                System.out.println(
                        "Avg.Marks: \t\t\t\t\t" + ((studentDBMSMarks[index] + studentPRFMarks[index]) / 2.0));
                String rank = (((index + 1) == 1) ? "First"
                        : ((index + 1) == 2) ? "Second"
                                : ((index + 1) == 3) ? "Third"
                                        : ((index + 1) == (studentID.length - 1)) ? "Last" : "None");
                System.out.println("Rank: \t\t\t\t\t\t" + (index + 1) + "(" + rank + ")");
                System.out.print("\nDo you want to search another student details? (y/n): ");
                String choice = input.nextLine();
                if (choice.equals("y")) {
                    break;
                } else {
                    menu();
                    break;
                }
            }
        }
    }
    // =====================PRINT STUDENT DETAILS=====================

    // =====================PRINT STUDENT RANKS=======================
    public static void printstudentRanks() {
        System.out.println("\t\tPRINT STUDENT's RANKS");

        Scanner input = new Scanner(System.in);

        sortTotal();

        System.out.println("\nRank\t\tID\t\tName\t\tTotal Marks\tAvg.Marks");

        for (int i = 0; i < studentID.length; i++) {
            if (studentTotalMarks[i] != 0) {
                System.out
                        .print("\n" + (i + 1) + "\t\t" + studentID[i] + "\t\t" + studentName[i] + "\t\t       "
                                + studentTotalMarks[i]
                                + "\t" + studentAverage[i]);
            }

        }

        System.out.print("\n\nDo you want to go back to main menu? (y/n): ");
        String choice = input.nextLine();
        if (choice.equals("y")) {
            menu();
        } else {
            return;
        }

    }

    public static void sortTotal() {
        int tempTotal[] = new int[studentID.length];
        double tempAverage[] = new double[studentID.length];

        for (int i = 0; i < tempTotal.length; i++) {
            tempTotal[i] = (studentPRFMarks[i] + studentDBMSMarks[i]);
            tempAverage[i] = tempTotal[i] / 2.0;
        }

        studentTotalMarks = tempTotal;
        studentAverage = tempAverage;

        for (int i = 0; i < studentTotalMarks.length; i++) {
            for (int j = 0; j < studentTotalMarks.length - 1; j++) {
                if (studentTotalMarks[j] < studentTotalMarks[j + 1]) {

                    int tempTot = studentTotalMarks[j];
                    studentTotalMarks[j] = studentTotalMarks[j + 1];
                    studentTotalMarks[j + 1] = tempTot;

                    String tempid = studentID[j];
                    studentID[j] = studentID[j + 1];
                    studentID[j + 1] = tempid;

                    String tempName = studentName[j];
                    studentName[j] = studentName[j + 1];
                    studentName[j + 1] = tempName;

                    double tempAvg = studentAverage[j];
                    studentAverage[j] = studentAverage[j + 1];
                    studentAverage[j + 1] = tempAvg;

                    int tempPRF = studentPRFMarks[j];
                    studentPRFMarks[j] = studentPRFMarks[j + 1];
                    studentPRFMarks[j + 1] = tempPRF;

                    int tempDBMS = studentDBMSMarks[j];
                    studentDBMSMarks[j] = studentDBMSMarks[j + 1];
                    studentDBMSMarks[j + 1] = tempDBMS;

                }
            }
        }
    }
    // =====================PRINT STUDENT RANKS=======================

    // =========================BEST IN PRF===========================
    public static void bestInPRF() {
        System.out.println("\t\tBEST IN PROGRAMMING FUNDAMENTALS");

        Scanner input = new Scanner(System.in);

        sortPRF();

        System.out.println("\nID\t\tName\t\tPF Marks\tDBMS Marks");

        for (int i = 0; i < studentID.length; i++) {
            if (studentPRFMarks[i] != 0) {
                System.out
                        .print(studentID[i] + "\t\t" + studentName[i] + "\t\t       "
                                + studentPRFMarks[i]
                                + "\t" + studentDBMSMarks[i]);
            }

        }

        System.out.print("\nDo you want to go back to main menu? (y/n): ");
        String choice = input.nextLine();
        if (choice.equals("y")) {
            menu();
        } else {
            return;
        }
    }

    public static void sortPRF() {
        for (int i = 0; i < studentPRFMarks.length; i++) {
            for (int j = 0; j < studentPRFMarks.length - 1; j++) {
                if (studentPRFMarks[j] < studentPRFMarks[j + 1]) {

                    int tempPRF = studentPRFMarks[j];
                    studentPRFMarks[j] = studentPRFMarks[j + 1];
                    studentPRFMarks[j + 1] = tempPRF;

                    String tempid = studentID[j];
                    studentID[j] = studentID[j + 1];
                    studentID[j + 1] = tempid;

                    String tempName = studentName[j];
                    studentName[j] = studentName[j + 1];
                    studentName[j + 1] = tempName;

                    int tempDBMS = studentDBMSMarks[j];
                    studentDBMSMarks[j] = studentDBMSMarks[j + 1];
                    studentDBMSMarks[j + 1] = tempDBMS;
                }
            }
        }
    }
    // =========================BEST IN PRF===========================

    // =========================BEST IN DBMS==========================
    public static void bestInDBMS() {
        System.out.println("\t\tBEST IN DATABASE MANAGEMENT SYSTEM");

        Scanner input = new Scanner(System.in);

        sortDBMS();

        System.out.println("\nID\t\tName\t\tDBMS Marks\tPF Marks");

        for (int i = 0; i < studentID.length; i++) {
            if (studentPRFMarks[i] != 0) {
                System.out
                        .print(studentID[i] + "\t\t" + studentName[i] + "\t\t       "
                                + studentDBMSMarks[i]
                                + "\t" + studentPRFMarks[i]);
            }

        }

        System.out.print("\nDo you want to go back to main menu? (y/n): ");
        String choice = input.nextLine();
        if (choice.equals("y")) {
            menu();
        } else {
            return;
        }
    }

    public static void sortDBMS() {
        for (int i = 0; i < studentPRFMarks.length; i++) {
            for (int j = 0; j < studentPRFMarks.length - 1; j++) {
                if (studentDBMSMarks[j] < studentDBMSMarks[j + 1]) {

                    int tempDBMS = studentDBMSMarks[j];
                    studentPRFMarks[j] = studentDBMSMarks[j + 1];
                    studentDBMSMarks[j + 1] = tempDBMS;

                    String tempid = studentID[j];
                    studentID[j] = studentID[j + 1];
                    studentID[j + 1] = tempid;

                    String tempName = studentName[j];
                    studentName[j] = studentName[j + 1];
                    studentName[j + 1] = tempName;

                    int tempPRF = studentPRFMarks[j];
                    studentPRFMarks[j] = studentPRFMarks[j + 1];
                    studentPRFMarks[j + 1] = tempPRF;
                }
            }
        }
    }
    // =========================BEST IN DBMS==========================

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

}