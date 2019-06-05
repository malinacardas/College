package ro.ubb.student.remoting.repository.impl;


import ro.ubb.student.remoting.paging.Page;
import ro.ubb.student.remoting.paging.PageImplementation;
import ro.ubb.student.remoting.paging.Pageable;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

class Paginator<T> {
    private Pageable pageable;
    private Iterable<T> elements;

    Paginator(Pageable pageable, Iterable<T> elements) {
        this.pageable = pageable;
        this.elements = elements;
    }

    Page<T> paginate() {
        Stream<T> result = StreamSupport.stream(elements.spliterator(), false)
                .skip(pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize());
        return new PageImplementation<>(pageable, result);
    }
}
