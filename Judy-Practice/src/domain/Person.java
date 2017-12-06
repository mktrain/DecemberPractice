package domain;

public class Person {
    String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.setAge(age);
    }

    @Override
    public String toString() {
        return name;
    }

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}


