package net.arxemond.springsecurityapp.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "student-list")
public class StudentList {

    private List<Student> studentList;

    protected StudentList() {
    }

    public StudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @javax.xml.bind.annotation.XmlElement(name = "student")
    public List<Student> getStudentList() {
        return studentList;
    }
}
