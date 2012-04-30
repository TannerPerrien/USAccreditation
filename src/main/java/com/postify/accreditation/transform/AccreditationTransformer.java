package com.postify.accreditation.transform;

import java.util.List;

public interface AccreditationTransformer<T, U> {

    List<T> transform(List<U> records);

}
