package app.models;

public class Pet {
 private String name;
 private Person ownerName;
 private int age;
 private Long id;
 private String specie;
 private String breed;
 private String color;
 private String size;
 private double weight;
 
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Person getOwner() {
	return ownerName;
}
public void setOwner(Person ownerName) {
	this.ownerName = ownerName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getSpecie() {
	return specie;
}
public void setSpecie(String specie) {
	this.specie = specie;
}
public String getBreed() {
	return breed;
}
public void setBreed(String breed) {
	this.breed = breed;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getSize() {
	return size;
}
public void setSize(String size) {
	this.size = size;
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}
 
 
}
