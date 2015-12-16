package ks.schkai.manager.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Konstantin on 16.12.2015.
 */


public class Person {

    private final StringProperty name;
    private final StringProperty typ;
    private final StringProperty damage;
    private final StringProperty parade;
    private final StringProperty special;


	/*
	 * Default constructor
	 */

    public Person(){
        this(null, null);
    }

    /**
     * Constructor with initial data
     *
     * @param name
     * @param typ
     */

    public Person(String name, String typ) {
        this.name = new SimpleStringProperty(name);
        this.typ = new SimpleStringProperty(typ);

        //dummy data
        this.damage = new SimpleStringProperty("1337");
        this.parade = new SimpleStringProperty("1338");
        this.special = new SimpleStringProperty("Kommt in Weibierform");
    }

	/*
	 * Getter and setter.
	 */

    public String getName(){
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setname(String name){
        this.name.set(name);
    }

    public String getTyp(){
        return typ.get();
    }

    public StringProperty typProperty() {
        return typ;
    }

    public void setTyp(String typ){
        this.typ.set(typ);
    }

    public String getDamage(){
        return damage.get();
    }

    public StringProperty damageProperty() {
        return damage;
    }

    public void setDamage(String damage){
        this.damage.set(damage);
    }

    public String getParade(){
        return parade.get();
    }

    public StringProperty paradeProperty() {
        return parade;
    }

    public void setParade(String parade){
        this.parade.set(parade);
    }

    public String getSpecial(){
        return special.get();
    }

    public StringProperty specialProperty() {
        return special;
    }
    public void setSpecial(String special){
        this.special.set(special);
    }

}
