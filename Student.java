class Student {
    int id;
    String name;
    int age;

    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return id + "," + name + "," + age;
    }

    public static Student fromString(String data) {
        String[] parts = data.split(",");
        return new Student(
            Integer.parseInt(parts[0]),
            parts[1],
            Integer.parseInt(parts[2])
        );
    }
}
