package ro.ubb.student.remoting.domain;

import java.util.Optional;

public class Grade extends BaseEntity<Long>{
    private int value;
    private Long forProblem;
    private Long toStudent;

    public Grade(){}

    public Grade(int value, Long forProblem, Long toStudent){
        this.value = value;
        this.forProblem = forProblem;
        this.toStudent = toStudent;
    }

    public Optional<Integer> getValue() {   return Optional.of(value);}

    public void setValue( int nValue )  {   this.value = nValue;}

    public Optional<Long> getForProblem()   {   return Optional.ofNullable(forProblem);}

    public void setForProblem ( Long nForProblem) {   this.forProblem = nForProblem;}

    public Optional<Long> getToStudent() {   return Optional.ofNullable(toStudent);}

    public void settoStudent( Long newToStudent) {   this.toStudent = newToStudent;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade = (Grade) o;

        if (value != grade.value) return false;
        if (!toStudent.equals(grade.toStudent)) return false;
        return forProblem.equals(grade.forProblem);
    }
    public String toTXF(){
        return value+","+forProblem+","+toStudent;
    }

    public String toXML() { return "to be implemented";}
    @Override
    public String toString() {
        return super.toString() + "," + value+","+forProblem+","+toStudent;
    }
}
