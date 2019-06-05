package ro.ubb.student.remoting.service;


import ro.ubb.student.remoting.ServiceException;
import ro.ubb.student.remoting.domain.Problem;
import ro.ubb.student.remoting.domain.validators.ValidatorException;
import ro.ubb.student.remoting.paging.Page;
import ro.ubb.student.remoting.paging.Pageable;
import ro.ubb.student.remoting.repository.PagingRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ProblemServiceServerImplementation implements ProblemService {
    private PagingRepository<Long, Problem> problemsRepository;
    private ExecutorService executorService;

    private Pageable pageable;
    private int page = 0;
    private int size = 1;

    public ProblemServiceServerImplementation(PagingRepository<Long, Problem> problemsRepository, ExecutorService executorService) {
        this.problemsRepository = problemsRepository;
        this.executorService = executorService;
    }

    public Boolean addProblem(Problem problem) {
        try {
            return CompletableFuture.supplyAsync(() -> {
                Optional<Problem> optional = problemsRepository.save(problem);
                optional.ifPresent(a -> {
                    throw new ValidatorException("The problem with id " + problem.getId() + " already exists in the repo");
                });
                return true;
            }, executorService).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.toString());
        }
    }

    @Override
    public List<Problem> getAllProblems() {
        try {
            return CompletableFuture.supplyAsync(() -> StreamSupport.stream(problemsRepository.findAll().spliterator(), false).sorted(((a, b) -> a.getId() < b.getId()
                    ? -1 : a.getId() > b.getId() ? 1 : 0)).collect(Collectors.toList()), executorService).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.toString());
        }
    }

    @Override
    public Boolean deleteProblem(Long id) {
        try {
            return CompletableFuture.supplyAsync(() -> {
                Optional<Problem> optional = problemsRepository.delete(id);
                optional.ifPresentOrElse(a -> {
                }, () -> {
                    throw new ValidatorException("The problem with id " + id + " does not exist in the repo");
                });
                return true;
            }, executorService).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.toString());
        }
    }

    @Override
    public Boolean updateProblem(Problem problem) {
        try {
            return CompletableFuture.supplyAsync(() -> {
                Optional<Problem> optional = problemsRepository.update(problem);
                optional.ifPresentOrElse(o -> {
                }, () -> {
                    throw new ValidatorException("The problem with id " + problem.getId() + " does not exist in the repo");
                });
                return true;
            }, executorService).get();
        }catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.toString());
        }
    }

    @Override
    public Boolean exists(Long id) {
        try {
            return CompletableFuture.supplyAsync(() -> StreamSupport.stream(problemsRepository.findAll().spliterator(), false).anyMatch(problem->problem.getId().equals(id))
                    , executorService).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.toString());
        }
    }


    @Override
    public Boolean setPageable(Pageable pageable) {
        try {
            return CompletableFuture.supplyAsync(() -> {
                this.pageable = pageable;
                return true;
            }, executorService).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.toString());
        }
    }

    @Override
    public List<Problem> getNextProblems() {
        try {
            return CompletableFuture.supplyAsync(() -> {
                Page<Problem> page = this.problemsRepository.findAll(this.pageable);
                setPageable(page.nextPageable());
                return page.getContent().collect(Collectors.toList());
            }, executorService).get();
        }catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.toString());
        }
    }



}
