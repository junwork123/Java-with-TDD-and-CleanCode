package org.cleancode.calculator.handlers;

import org.cleancode.calculator.calcuables.Point;

import java.util.regex.Pattern;

public class PointHandler extends Handler<Point> {
    private PointHandler(){
        super(Pattern.compile("^\\([-+]?\\d+,[-+]?\\d+\\)$"));
    }
    @Override
    public Point parse(String item) {
        if(!canHandle(item)){
            throw new IllegalArgumentException("Invalid input");
        }
        String[] split = item.replaceAll("[()]", "").split(",");
        return new Point(NumberHandler.handle(split[0]), NumberHandler.handle(split[1]));
    }
    private static final PointHandler INSTANCE = new PointHandler();
    public static boolean canHandle(String input){
        return INSTANCE.supports(input);
    }
    public static Point handle(String item) {
        return INSTANCE.parse(item);
    }
}
