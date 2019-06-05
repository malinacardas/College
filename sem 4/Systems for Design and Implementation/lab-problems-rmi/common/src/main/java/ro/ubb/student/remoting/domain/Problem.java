package ro.ubb.student.remoting.domain;

import java.util.Optional;


public class Problem extends BaseEntity<Long>{
    private String problemStatement;


    public Problem(){}

    public Problem(String problemStatement){
        this.problemStatement = problemStatement;
    }


    public Optional<String> getProblemStatement()   {   return Optional.ofNullable(problemStatement);}

    public void setProblemStatement ( String nProblemStatement) {   this.problemStatement = nProblemStatement;}


    @Override
    public boolean equals(Object o) {
        Problem problem;
        problem = (Problem) o;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return problemStatement.equals(problem.problemStatement);
    }

    @Override
    public String toString() {
        return super.toString() + "," + problemStatement;
    }
    public String toTXF(){
        return problemStatement;
    }
    public String toXML(){
        return "<statement>"+problemStatement+"</statement";
    }
}
