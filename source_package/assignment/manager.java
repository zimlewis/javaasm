package assignment;



public class manager extends employee{

    public double pres;

    public manager(String _id , String _name , double _salary , double _pres){
        super(_id, _name, _salary);
        this.pres = _pres;
    }

    public double get_sal(){
        return this.pres + super.get_sal();
    }
}
