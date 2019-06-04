/*
 * Copyright 2017-2019 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.data.model;

import edu.umd.cs.findbugs.annotations.NonNull;

import java.util.Iterator;
import java.util.List;

/**
 * Inspired by the Spring Data's {@code Slice} and GORM's {@code PagedResultList}, this models a type that supports
 * pagination operations.
 *
 * <p>A slice is a result list associated with a particular {@link Pageable}</p>
 *
 * @param <T> The generic type
 * @author graemerocher
 * @since 1.0.0
 */
public interface Slice<T> extends Iterable<T> {

    /**
     * @return The content.
     */
    @NonNull List<T> getContent();

    /**
     * @return The pageable for this slice.
     */
    @NonNull Pageable getPageable();

    /**
     * @return The page number
     */
    default int getPageNumber() {
        return getPageable().getNumber();
    }

    /**
     * @return The next pageable
     */
    default @NonNull Pageable nextPageable() {
        return getPageable().next();
    }

    /**
     * @return The previous pageable.
     */
    default @NonNull Pageable previousPageable() {
        return getPageable().previous();
    }

    /**
     * @return The offset.
     */
    default long getOffset() {
        return getPageable().getOffset();
    }

    /**
     * @return The size of the slice.
     */
    default int getSize() {
        return getPageable().getSize();
    }

    /**
     * @return Whether the slize is empty
     */
    default boolean isEmpty() {
        return getContent().isEmpty();
    }

    /**
     * @return The sort
     */
    default @NonNull Sort getSort() {
        return getPageable();
    }

    /**
     * @return The number of elements
     */
    default int getNumberOfElements() {
        return getContent().size();
    }

    @Override
    @NonNull
    default Iterator<T> iterator() {
        return getContent().iterator();
    }

    /**
     * Creates a slice from the given content and pageable.
     * @param content The content
     * @param pageable The pageable
     * @param <T2> The generic type
     * @return The slice
     */
    static @NonNull <T2> Slice<T2> of(@NonNull List<T2> content, @NonNull Pageable pageable) {
        return new DefaultSlice<>(content, pageable);
    }
}