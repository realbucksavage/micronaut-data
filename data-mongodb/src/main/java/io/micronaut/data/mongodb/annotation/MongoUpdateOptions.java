/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.data.mongodb.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines a custom MongoDB update query options.
 *
 * @author Denis Stepanov
 * @since 3.3.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.TYPE})
@Documented
@Inherited
public @interface MongoUpdateOptions {

    /**
     * The upsert.
     *
     * @return The upsert value
     */
    boolean upsert() default false;

    /**
     * The bypassDocumentValidation.
     *
     * @return The bypassDocumentValidation value
     */
    boolean bypassDocumentValidation() default false;

    /**
     * The hint.
     *
     * @return The hint value
     */
    String hint() default "";

}
