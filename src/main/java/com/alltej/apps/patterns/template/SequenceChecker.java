package com.alltej.apps.patterns.template;

import java.util.Optional;

public abstract class SequenceChecker {

    // ...

    public boolean isSequenceSuccessful() {
        Optional<byte[]> result1 = doSomething();
        Optional<byte[]> result2 = doAnotherThing(result1);
        Optional<byte[]> result3 = doSomethingElse(result2);
        return doMoreStuff(result3);
    }

    protected abstract boolean doMoreStuff(Optional<byte[]> result);

    protected abstract Optional<byte[]> doSomethingElse(Optional<byte[]> result);

    protected abstract Optional<byte[]> doAnotherThing(Optional<byte[]> result);

    protected abstract Optional<byte[]> doSomething();

    // ...
}


