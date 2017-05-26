package com.microsoft.exampledep;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DistanceTest {
    @Test
    public void testDistance_TopSoil_Bedrock() {
        List<Route> routes = new ArrayList<Route>(1);
        routes.add(new Route("Somewhere, Topsoil, WA", "SomewhereElse, Bedrock, WA"));
        int distance = DistanceCalculator.getTotalDistance(routes);
        assertEquals(2, distance);
    }

    @Test
    public void testDistance_Bedrock_Topsoil() {
        List<Route> routes = new ArrayList<Route>(1);
        routes.add(new Route("Somewhere, Bedrock, WA", "SomewhereElse, Topsoil, WA"));
        int distance = DistanceCalculator.getTotalDistance(routes);
        assertEquals(2, distance);
    }

    @Test
    public void testDistance_Bedrock_Unknown() {
        List<Route> routes = new ArrayList<Route>(1);
        routes.add(new Route("Somewhere, Bedrock, WA", "SomewhereElse, Otherplace, WA"));
        int distance = DistanceCalculator.getTotalDistance(routes);
        assertEquals(2, distance);
    }
}
