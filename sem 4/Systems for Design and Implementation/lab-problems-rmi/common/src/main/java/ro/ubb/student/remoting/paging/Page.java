package ro.ubb.student.remoting.paging;

import java.util.stream.Stream;

/**
 * author: radu
 */
public interface Page<T> {
    Pageable getPageable();

    Pageable nextPageable();

    Stream<T> getContent();


}
