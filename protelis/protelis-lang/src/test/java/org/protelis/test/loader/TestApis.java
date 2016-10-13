package org.protelis.test.loader;

import java.io.IOException;

import org.junit.Test;

/**
 * Testing Protelis core libraries.
 */
public class TestApis {

    /**
     * Test the number of neighbors of each device.
     */
    @Test
    public void testNeighborhood() {
        test("neighborhood");
    }

    /**
     * Test distanceTo function.
     */
    @Test
    public void testDistanceTo() {
        test("distanceTo");
    }

    /**
     * Test distanceTo with obstacle.
     */
    @Test
    public void testDistanceToWithObstacle() {
        test("distanceToWithObstacle");
    }

    /**
     * Test forecastObstacle.pt.
     */
    @Test
    public void testForecastObstacle() {
        test("forecastObstacle");
    }

    /**
     * Test broadcast.pt.
     */
    @Test
    public void testBroadcast() {
        test("broadcast");
    }

    /**
     * Test self.nbrRange().
     */
    @Test
    public void testNbrRange() {
        test("nbrRange");
    }

    /**
     * Test addRange.pt.
     */
    @Test
    public void testAddRange() {
        test("addRange");
    }

    /**
     * Test G.pt.
     */
    @Test
    public void testG() {
        test("G");
    }

    /**
     * Test distanceBetween.pt.
     */
    @Test
    public void testDistanceBetween() {
        test("distanceBetween");
    }

    /**
     * Test T function.
     */
    @Test
    public void testT() {
        test("T");
    }

    /**
     * Test cyclicTimer function.
     */
    @Test
    public void testCyclicTimer() {
        test("cyclicTimer", 1, 3);
    }
    /**
     * Test limitedMemory function.
     */
    @Test
    public void testLimitedMemory() {
        test("limitedMemory", 1, 3);
    }

    /**
     * Test TFilter function.
     */
    @Test
    public void testTFilter() {
        test("tfilter");
    }

    /**
     * Test summarize.pt.
     */
    @Test
    public void testSummarize() {
        test("summarize");
    }

    /**
     * Test C.pt.
     */
    @Test
    public void testC() {
        test("C");
    }

    /**
     * Test CMultisum.pt.
     */
    @Test
    public void testCMultisum() {
        test("Cmultisum");
    }

    /**
     * Test gossip.pt.
     */
    @Test
    public void testGossip() {
        test("gossip");
    }

    /**
     * Test gossip2.pt.
     */
    @Test
    public void testGossip2() {
        test("gossip2");
    }

    /**
     * Test gossip3.pt.
     */
    @Test
    public void testGossip3() {
        test("gossip3");
    }

    /**
     * Test boundedSpreading.pt.
     */
    @Test
    public void testBoundSpreading() {
        test("boundSpreading");
    }

    /**
     * Test constrainSpreading.pt.
     */
    @Test
    public void testConstrainSpreading() {
        test("constrainSpreading");
    }

    /**
     * Test gossipEver.pt.
     */
    @Test
    public void testGossipEver() {
        test("gossipEver");
    }

    /**
     * Test opinionFeedback.pt.
     */
    @Test
    public void testOpinionFeedback() {
        test("opinionFeedback");
    }

    /**
     * Test laplacianConsensus.pt.
     */
    @Test
    public void testLaplacianConsensus() {
        test("laplacianConsensus");
    }

    /**
     * Test voronoiPartitioning.pt.
     */
    @Test
    public void testVoronoiPartitioning() {
        test("voronoiPartitioning");
    }

    /**
     * Test channel.pt.
     */
    @Test
    public void testChannel() {
        test("channel");
    }

    /**
     * Test channel2.pt.
     */
    @Test
    public void testChannel2() {
        test("channel2");
    }

    /*
     * From this point the rest of the file is not tests, but utility methods
     */

    private static void test(final String file) {
        test(file, Tester.EXAMPLE_RUNS);
    }

    private static void test(final String file, final int runs) {
        try {
            Tester.test(file, runs);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void test(final String file, final int min, final int max) {
        try {
            Tester.test(file, min, max);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
