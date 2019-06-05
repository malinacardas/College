package ro.ubb.student.remoting.repository;





import ro.ubb.student.remoting.domain.BaseEntity;
import ro.ubb.student.remoting.paging.Page;
import ro.ubb.student.remoting.paging.Pageable;

import java.io.Serializable;

public interface PagingRepository<ID extends Serializable,
        T extends BaseEntity<ID>>
        extends Repository<ID, T> {

    Page<T> findAll(Pageable pageable);

    //TODO: any other methods are allowed...

}
