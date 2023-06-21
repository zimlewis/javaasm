package assignment;

import java.util.*;
import qu_method.*;
import java.text.*;

public class assignment {
    static Scanner s = new Scanner(System.in);
    static List<employee> e = new ArrayList<>();

    private static void y1() {
        int con = 0;
        do {
            int type = input_limit.int_input(s,
                    "Which type of employee do you want to add?(1: normal, 2: manager, 3: marketing): ");

            while (type < 1 || type > 3) {
                type = input_limit.int_input(s, "please enter 1 - 3: ");
            }

            type--;

            List<String> ids = new ArrayList<String>();
            for (int i = 0; i < e.size(); i++) {
                ids.add(e.get(i).info().get("id"));
            }

            switch (type) {
                case 0: {
                    System.out.println("Enter employee information: \n");
                    s.nextLine();
                    String name = input_limit.name_input(s, ">> Name: ");
                    String id = input_limit.string_input(s, ">> Id: ");
                    while (ids.contains(id)) {
                        System.out.printf("The id '%s' is already existed.\n", id);
                        id = input_limit.string_input(s, ">> Id: ");
                    }
                    Double salary = input_limit.double_input(s, ">> Salary: ");

                    employee temp = new employee(id, name, salary);
                    e.add(temp);
                    break;
                }
                case 1: {
                    System.out.println("Enter manager information: \n");
                    s.nextLine();
                    String name = input_limit.name_input(s, ">> Name: ");
                    String id = input_limit.string_input(s, ">> Id: ");
                    Double salary = input_limit.double_input(s, ">> Salary: ");
                    Double pres = input_limit.double_input(s, ">> Prestige: ");

                    employee temp = new manager(id, name, salary, pres);
                    e.add(temp);
                    break;
                }
                case 2: {
                    System.out.println("Enter marketing information: \n");
                    s.nextLine();
                    String name = input_limit.name_input(s, ">> Name: ");
                    String id = input_limit.string_input(s, ">> Id: ");
                    Double salary = input_limit.double_input(s, ">> Salary: ");
                    Double commission = input_limit.double_input(s, ">> Commission: ");
                    Double sales = input_limit.double_input(s, ">> Sales: ");

                    employee temp = new marketing(id, name, salary, sales, commission);
                    e.add(temp);
                    break;
                }
            }

            System.out.println("");

            con = input_limit.int_input(s, "Press 1 to continue, 0 to exit: ");
        } while (con == 1);

    }

    private static void y2() {
        output_formatter of = new output_formatter();
        of.add("Name", "|", "Id", "|", "Position", "|", "Salary", "|", "Income taxes", "|");

        for (int i = 0; i < e.size(); i++) {
            of.add(e.get(i).info().get("name"), "|", e.get(i).info().get("id"), "|", e.get(i).info().get("type"), "|",
                    e.get(i).info().get("salary"), "|", e.get(i).info().get("taxes"), "|");
        }

        System.out.println("\n" + of.format());
        s.nextLine();
        s.nextLine();
    }

    private static void y3() {
        s.nextLine();
        List<String> ids = new ArrayList<String>();
        for (int i = 0; i < e.size(); i++) {
            ids.add(e.get(i).info().get("id"));
        }

        String id = input_limit.string_input(s, ">> Id: ");

        if (ids.contains(id)) {
            output_formatter of = new output_formatter();
            int index = ids.indexOf(id);
            of.add("Name", "|", "Id", "|", "Position", "|", "Salary", "|", "Income taxes", "|");
            of.add(e.get(index).info().get("name"), "|", e.get(index).info().get("id"), "|",
                    e.get(index).info().get("type"), "|", e.get(index).info().get("salary"), "|",
                    e.get(index).info().get("taxes"), "|");
            System.out.println("\n" + of.format());

        } else
            System.out.printf("\nThe id '%s' doesn't exist", id);

        s.nextLine();
    }

    private static void y4() {
        s.nextLine();
        List<String> ids = new ArrayList<String>();
        for (int i = 0; i < e.size(); i++) {
            ids.add(e.get(i).info().get("id"));
        }

        String id = input_limit.string_input(s, "Id of the employee you want to remove: ");

        if (ids.contains(id)) {
            int index = ids.indexOf(id);
            System.out.printf("\nRemove %s from employees list", e.get(index).info().get("name"));
            e.remove(index);

        } else
            System.out.printf("\nThe id '%s' doesn't exist", id);

        s.nextLine();
    }

    private static void y5() {
        s.nextLine();
        List<String> ids = new ArrayList<String>();
        for (int i = 0; i < e.size(); i++) {
            ids.add(e.get(i).info().get("id"));
        }

        String id = input_limit.string_input(s, "Id of the employee you want to remove: ");

        if (ids.contains(id)) {
            int index = ids.indexOf(id);

            int type = input_limit.int_input(s,
                    "Which type of employee do you want to change to?(1: normal, 2: manager, 3: marketing): ");

            while (type < 1 || type > 3) {
                type = input_limit.int_input(s, "please enter 1 - 3: ");
            }

            type--;

            employee current = e.get(index);

            switch (type) {
                case 0: {
                    System.out.println("Enter employee information: \n");
                    s.nextLine();
                    String name = input_limit.name_input(s, ">> Name: ");
                    String _id = input_limit.string_input(s, ">> Id: ");
                    while (ids.contains(_id)) {
                        System.out.printf("The id '%s' is already existed.\n", _id);
                        _id = input_limit.string_input(s, ">> Id: ");
                    }
                    Double salary = input_limit.double_input(s, ">> Salary: ");

                    employee temp = new employee(_id, name, salary);
                    e.set(index, temp);
                    break;
                }
                case 1: {
                    System.out.println("Enter manager information: \n");
                    s.nextLine();
                    String name = input_limit.name_input(s, ">> Name: ");
                    String _id = input_limit.string_input(s, ">> Id: ");
                    Double salary = input_limit.double_input(s, ">> Salary: ");
                    Double pres = input_limit.double_input(s, ">> Prestige: ");

                    employee temp = new manager(_id, name, salary, pres);
                    e.set(index, temp);
                    break;
                }
                case 2: {
                    System.out.println("Enter marketing information: \n");
                    s.nextLine();
                    String name = input_limit.name_input(s, ">> Name: ");
                    String _id = input_limit.string_input(s, ">> Id: ");
                    Double salary = input_limit.double_input(s, ">> Salary: ");
                    Double commission = input_limit.double_input(s, ">> Commission: ");
                    Double sales = input_limit.double_input(s, ">> Sales: ");

                    employee temp = new marketing(_id, name, salary, sales, commission);
                    e.set(index, temp);
                    break;
                }
            }

            System.out.printf("sucecfully replace %s with %s", current.info().get("name"),
                    e.get(index).info().get("name"));
            System.out.println("");

        } else
            System.out.printf("\nThe id '%s' doesn't exist", id);

        s.nextLine();
    }

    private static void y6() {
        double _i_1 = input_limit.double_input(s, "Enter minimum salary: ");
        double _i_2 = input_limit.double_input(s, "Enter max salary: ");
        double _max = Math.max(_i_1, _i_2);
        double _min = Math.min(_i_1, _i_2);

        DecimalFormat df = new DecimalFormat("#,###");
        df.setMaximumFractionDigits(340);

        List<Double> salaries = new ArrayList<Double>();
        for (int i = 0; i < e.size(); i++) {
            salaries.add(Double.valueOf(e.get(i).info().get("salary").replace(",", "")));
        }

        List<employee> temp_emp = new ArrayList<employee>();
        for (int i = 0; i < e.size(); i++) {

            if (Double.valueOf(e.get(i).info().get("salary").replace(",", "")) >= _min
                    && Double.valueOf(e.get(i).info().get("salary").replace(",", "")) <= _max) {
                temp_emp.add(e.get(i));
            }

        }

        if (temp_emp.size() > 0) {
            output_formatter of = new output_formatter();
            of.add("Name", "|", "Id", "|", "Position", "|", "Salary", "|", "Income taxes", "|");

            for (int i = 0; i < temp_emp.size(); i++) {
                of.add(temp_emp.get(i).info().get("name"), "|", temp_emp.get(i).info().get("id"), "|",
                        temp_emp.get(i).info().get("type"), "|", temp_emp.get(i).info().get("salary"), "|",
                        temp_emp.get(i).info().get("taxes"), "|");
            }

            System.out.println("\n" + of.format());
        } else
            System.out.printf("\nThere is no employees with salary between %s and %s", df.format(_min),
                    df.format(_max));

        s.nextLine();
        s.nextLine();

    }

    private static void y7() {
        for (int i = 0; i < e.size(); i++) {
            for (int j = i + 1; j < e.size(); j++) {
                String name_i = string_handler.reverse_string_by_word(e.get(i).info().get("name"));
                String name_j = string_handler.reverse_string_by_word(e.get(j).info().get("name"));

                if (name_i.compareToIgnoreCase(name_j) > 0) {
                    employee _temp = e.get(i);
                    e.set(i, e.get(j));
                    e.set(j, _temp);
                }
            }
        }
        System.out.println("Successfully");
        s.nextLine();
        s.nextLine();
    }

    private static void y8() {
        for (int i = 0; i < e.size(); i++) {
            for (int j = i + 1; j < e.size(); j++) {
                Double sal_i = Double.valueOf(e.get(i).info().get("salary").replace(",", ""));
                Double sal_j = Double.valueOf(e.get(j).info().get("salary").replace(",", ""));

                if (sal_j > sal_i) {
                    employee _temp = e.get(i);
                    e.set(i, e.get(j));
                    e.set(j, _temp);
                }
            }
        }
        System.out.println("Successfully");
        s.nextLine();
        s.nextLine();
    }

    private static void y9() {
        List<employee> old = e;
        y8();
        System.out.print("\033\143");

        output_formatter of = new output_formatter();
        of.add("Name", "|", "Id", "|", "Position", "|", "Salary", "|", "Income taxes", "|");

        for (int i = 0; i < Math.min(5 , e.size()); i++) {
            of.add(e.get(i).info().get("name"), "|", e.get(i).info().get("id"), "|", e.get(i).info().get("type"), "|",
                    e.get(i).info().get("salary"), "|", e.get(i).info().get("taxes"), "|");
        }

        System.out.println("\n" + of.format());
        s.nextLine();

        e = old;
    }

    public static void main(String[] args) {

        while (true) {
            System.out.print("\033\143");
            String[] names_array = {
                    "Employees list input",
                    "Employees list output",
                    "Find employees using id",
                    "Remove employee",
                    "Edit employee",
                    "Find employees using salary",
                    "Sort employees by name",
                    "Sort employees by salary",
                    "Print 5 highest paying employees"
            };
            HashMap<String, Runnable> func_map = new HashMap<>();

            func_map.put(names_array[0], assignment::y1);
            func_map.put(names_array[1], assignment::y2);
            func_map.put(names_array[2], assignment::y3);
            func_map.put(names_array[3], assignment::y4);
            func_map.put(names_array[4], assignment::y5);
            func_map.put(names_array[5], assignment::y6);
            func_map.put(names_array[6], assignment::y7);
            func_map.put(names_array[7], assignment::y8);
            func_map.put(names_array[8], assignment::y9);

            System.out.print("Select using number: ");

            for (int i = 0; i < names_array.length; i++) {
                System.out.printf("\n%d. %s", i + 1, names_array[i]);
            }

            System.out.print("\n0. exit");

            int selection;
            System.out.println("");

            do {
                selection = input_limit.int_input(s, "Your selection: ", "Integer only") - 1;
                if (selection == -1) {
                    System.exit(0);
                    s.close();
                }
            } while (selection < 0 || selection > names_array.length - 1);

            System.out.print("\033\143");
            func_map.get(names_array[selection]).run();
        }
    }
}
