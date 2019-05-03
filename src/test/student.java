package test;

import java.util.Date;

public class student {
	
	private String name;
	private int age;
	private int id;
	private Date date;
	private double score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "student [name=" + name + ", age=" + age + ", id=" + id + ", date=" + date + ", score=" + score + "]";
	}
	
}
