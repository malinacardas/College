package ro.ubb.student.remoting.repository.impl;



import ro.ubb.student.remoting.domain.Problem;
import ro.ubb.student.remoting.domain.validators.Validator;
import ro.ubb.student.remoting.domain.validators.ValidatorException;
import ro.ubb.student.remoting.paging.Page;
import ro.ubb.student.remoting.paging.Pageable;
import ro.ubb.student.remoting.repository.PagingRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PagingProblemRepository implements PagingRepository<Long, Problem> {

    private static final String URL = System.getProperty("url");
    private static final String USER = System.getProperty("user");
    private static final String PASSWORD = System.getProperty("password");
    private Validator<Problem> problemValidator;

    public PagingProblemRepository(Validator<Problem> problemValidator)
    {

        this.problemValidator = problemValidator;
    }

    @Override
    public Page<Problem> findAll(Pageable pageable) {
        Paginator<Problem> paginator = new Paginator<>(pageable, this.findAll());
        return paginator.paginate();
    }


/*
    public Optional<Problem> findOne(Long id) {
        List<Problem> problemList = new ArrayList<>();
        String sql = "SELECT * FROM problems WHERE Id=?";

        try(Connection connection = getDatabaseConnection() ; PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();

            Problem problem = initializeProblemFromDb(resultSet);
            return Optional.of(problem);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }


        return Optional.empty();
    }
*/

    @Override
    @SuppressWarnings("Duplicates")
    public Optional<Problem> delete(Long id) {
        String sql = "DELETE FROM problems WHERE id=?";
        try (Connection connection = getDatabaseConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1,id);
            statement.executeUpdate();
            Problem problem=new Problem();
            problem.setId(id);
            return Optional.of(problem);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Iterable<Problem> findAll() {

        List<Problem> problemList = new ArrayList<>();
        String sql = "select * from problems";

        try (PreparedStatement statement = getDatabaseConnection().prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Long Id = (long)resultSet.getInt("Id");
                String Statement = resultSet.getString("Statement");
                Problem problem = new Problem(Statement);
                problem.setId(Id);
                problemList.add(problem);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problemList;
    }

    @Override
    public Optional<Problem> save(Problem entity) throws ValidatorException {
        String sql = "INSERT INTO problems (`Id`, `Statement`) VALUES (?,?)";
        try ( Connection connection = getDatabaseConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getProblemStatement().orElse(""));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<Problem> update(Problem entity) throws ValidatorException {
        this.problemValidator.validate(entity);
        String sql = "UPDATE problems AS a SET Statement=? WHERE Id=?";
        try(Connection connection = getDatabaseConnection(); PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setString(1,entity.getProblemStatement().orElse(""));
            statement.setLong(2,entity.getId());
            statement.executeUpdate();
            return Optional.of(entity);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
/*
    private Problem initializeProblemFromDb(ResultSet resultSet) throws SQLException {
        Long Id = (long)resultSet.getInt("Id");
        String Statement = resultSet.getString("Statement");


        Problem problem = new Problem(Statement);
        problem.setId(Id);
        return problem;
    }
    */
}
