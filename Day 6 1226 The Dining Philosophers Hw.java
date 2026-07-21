class DiningPhilosophers {

    Semaphore[] f = new Semaphore[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++)
            f[i] = new Semaphore(1);
    }

    public void wantsToEat(int p,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        int l = p, r = (p + 1) % 5;

        if (p % 2 == 0) {
            f[l].acquire();
            f[r].acquire();
        } else {
            f[r].acquire();
            f[l].acquire();
        }

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();

        f[l].release();
        f[r].release();
    }
}
