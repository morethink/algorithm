//package algorithm.leetcode;
//
//import java.util.HashMap;
//
///**
// * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
// *
// * @author 李文浩
// * @date 2018/2/13
// */
//public class Leetcode_149_MaxPointsOnALine {
//    public static class Point {
//        int x;
//        int y;
//
//        Point() {
//            x = 0;
//            y = 0;
//        }
//
//        Point(int a, int b) {
//            x = a;
//            y = b;
//            Map = new HashMap();
//        }
//    }
//
//    public static void main(String[] args) {
//        Point[] points = {
////                new Point(10, 10),
////                new Point(20, 22),
////                new Point(30, 31),
////                new Point(40, 40),
////                new Point(23, 26),
////                new Point(65, 36),
//                new Point(-4, -4),
//                new Point(-8, -582),
//                new Point(-3, 3),
//                new Point(-9, -651),
//                new Point(9, 591),
//        };
//        for (Point point : points) {
//            System.out.print(point.x + "," + point.y + "          ");
//        }
//        System.out.println();
//        Leetcode_149_MaxPointsOnALine maxPointsOnALine = new Leetcode_149_MaxPointsOnALine();
//        System.out.println(maxPointsOnALine.maxPoints(points));
//    }
//
//    public int maxPoints(Point[] points) {
//        if (points.length == 0) {
//            return 0;
//        } else if (points.length == 1) {
//            return 1;
//        } else if (points.length == 2) {
//            return 2;
//        } else {
//            int[] nums = new int[points.length];
//            for (int i = 0; i < points.length - 2; i++) {
//                int[] nums1 = new int[points.length];
//                for (int k = i + 1; k < points.length - 1; k++) {
//                    int num = 2 + repeatPoints(points, i);
//
//
////                    if (points[i].x == points[k].x && points[i].y != points[k].y) {
////                        for (int j = i + 2; j < points.length; j++) {
////                            if (points[i].x == points[j].x) {
////                                num++;
////                            }
////                        }
////                    } else {
//                    double slope = (points[i].y - points[k].y) * 1.0 / (points[i].x - points[k].x);
//                    System.out.print("第" + i + "个点的斜率:" + slope + " ");
//                    for (int j = i + 2; j < points.length; j++) {
//                        System.out.print((points[i].y - points[j].y) * 1.0 / (points[i].x - points[j].x) + " ");
//
//                        if (slope == (points[i].y - points[j].y) * 1.0 / (points[i].x - points[j].x)) {
//                            num++;
//                        }
//                    }
//                    System.out.println();
////                    }
//                    nums[1] = num;
//
//                }
//                int max = 0;
//                for (int m = max + 1; m < nums1.length; m++) {
//                    if (nums1[i] > nums1[max]) {
//                        max = i;
//                    }
//                }
//                nums[i] = nums1[max];
//            }
//            for (int i : nums) {
//                System.out.print(i + "              ");
//            }
//            System.out.println();
//            int max = 0;
//            for (int i = max + 1; i < nums.length; i++) {
//                if (nums[i] > nums[max]) {
//                    max = i;
//                }
//            }
//            return nums[max] > points.length ? points.length : nums[max];
//        }
//    }
//
//
//    public int repeatPoints(Point[] points, int k) {
//        int num = -1;
//        for (int i = 0; i < points.length; i++) {
//            if (points[i].x == points[k].x && points[i].y == points[k].y) {
//                num++;
//            }
//        }
//        return num;
//    }
//}
