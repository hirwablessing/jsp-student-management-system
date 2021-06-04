package com.example.demo.models;
import com.example.demo.Enum.AssignmentStatus;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name="course_assignment")
public class CourseAssignment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String assignedOn;
    private String lastUpdatedBy;
    @Enumerated(EnumType.STRING)
    private AssignmentStatus status;
    private String localStatusChangeOn;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Course course;

    public CourseAssignment() {
    }
    public CourseAssignment(Long id, String assignedOn, String lastUpdatedBy, AssignmentStatus status, String localStatusChangeOn) {
        this.id = id;
        this.assignedOn = assignedOn;
        this.lastUpdatedBy = lastUpdatedBy;
        this.status = status;
        this.localStatusChangeOn = localStatusChangeOn;
    }
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }
    public void setLastUpdatedBy(String assignedBy) {
        this.lastUpdatedBy = assignedBy;
    }
    public AssignmentStatus getStatus() {
        return status;
    }
    public void setStatus(AssignmentStatus status) {
        this.status = status;
    }
    public String getLocalStatusChangeOn() {
        return localStatusChangeOn;
    }
    public void setLocalStatusChangeOn(String localStatusChangeOn) {
        this.localStatusChangeOn = localStatusChangeOn;
    }
    public CourseAssignment(Long id, String whenAssigned) {
        this.id = id;
        this.assignedOn = whenAssigned;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAssignedOn() {
        return assignedOn;
    }
    public void setAssignedOn(String whenAssigned) {
        this.assignedOn = whenAssigned;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseAssignment that = (CourseAssignment) o;
        return Objects.equals(id, that.id) && Objects.equals(assignedOn, that.assignedOn);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, assignedOn);
    }
    @Override
    public String toString() {
        return "CourseAssignment{" +
                "id=" + id +
                ", whenAssigned=" + assignedOn +
                '}';
    }
}