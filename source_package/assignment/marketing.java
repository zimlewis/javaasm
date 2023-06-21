package assignment;


public class marketing extends employee{
    public double sales;
    public double commission;
    public marketing(String _id , String _name , double _salary , double _sales , double _comn){
        super(_id, _name, _salary);
        this.sales = _sales;
        this.commission = _comn;
    }

    public double get_sal(){
        return this.sales + this.commission + super.get_sal();
    }
    
}
