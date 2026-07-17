lass FizzBuzz {
    private int n;
    private int current = 1;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (current <= n && !(current % 3 == 0 && current % 5 != 0)) {
                    condition.await();
                }

                if (current > n) {
                    condition.signalAll();
                    return;
                }

                printFizz.run();
                current++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (current <= n && !(current % 5 == 0 && current % 3 != 0)) {
                    condition.await();
                }

                if (current > n) {
                    condition.signalAll();
                    return;
                }

                printBuzz.run();
                current++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (current <= n && current % 15 != 0) {
                    condition.await();
                }

                if (current > n) {
                    condition.signalAll();
                    return;
                }

                printFizzBuzz.run();
                current++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x".
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            lock.lock();
            try {
                while (current <= n && (current % 3 == 0 || current % 5 == 0)) {
                    condition.await();
                }

                if (current > n) {
                    condition.signalAll();
                    return;
                }

                printNumber.accept(current);
                current++;
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
