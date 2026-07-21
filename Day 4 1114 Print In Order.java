class Foo {
    CountDownLatch first = new CountDownLatch(1);
    CountDownLatch second = new CountDownLatch(1);

    public Foo() {}

    public void first(Runnable printFirst) {
        printFirst.run();
        first.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        first.await();
        printSecond.run();
        second.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        second.await();
        printThird.run();
    }
}
