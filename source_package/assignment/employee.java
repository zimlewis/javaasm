package assignment;


import java.util.*;
import java.text.*;


class employee {
    public String id;
    public String name;
    public double salary;
    public String type;

    public employee(String _id , String _name , double _salary){
        this.id = _id;
        this.name = _name;
        this.salary = _salary;
        this.type = this.getClass().getSimpleName();
    }

    public Map<String , String> info(){
        Map<String , String> information = new HashMap<String , String>();

        DecimalFormat df = new DecimalFormat("#,###");
        df.setMaximumFractionDigits(340);
        
        information.put("name" , this.name);
        information.put("salary" , df.format(get_sal()));
        information.put("id" , this.id);
        information.put("taxes", df.format(taxes()));
        information.put("type", this.type);
        
        return information;
    }

    public double taxes(){
        double sal = get_sal();
        double tax = Math.min(sal , 9000000) * 0;
        sal -= Math.min(sal , 9000000);
        tax += Math.min(sal , 6000000) * 0.1;
        sal -= Math.min(sal , 6000000);
        tax += sal * 0.12;

        return tax;
    }

    public double get_sal(){
        return salary;
    }
}
