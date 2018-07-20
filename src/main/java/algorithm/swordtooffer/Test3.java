package algorithm.swordtooffer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author 李文浩
 * @version 2017/7/20.
 */
public class Test3 {
    public static void main(String[] args) {
        int[][] array = {{1, 5, 9}, {2, 6, 10}};
        Test3 solution = new Test3();
        System.out.println(solution.Find(3, array));
    }

    public boolean Find(int target, int[][] array) {
        if (array == null || array.length < 1 || array[0].length < 1) {
            return false;
        }

        int rows = array.length; // 数组的行数  
        int cols = array[1].length; // 数组行的列数  

        int row = 0; // 起始开始的行号  
        int col = cols - 1; // 起始开始的列号  

        // 要查找的位置确保在数组之内  
        while (row >= 0 && row < rows && col >= 0 && col < cols) {
            if (array[row][col] == target) { // 如果找到了就直接退出  
                return true;
            } else if (array[row][col] > target) { // 如果找到的数比要找的数大，说明要找的数在当前数的左边  
                col--; // 列数减一，代表向左移动  
            } else { // 如果找到的数比要找的数小，说明要找的数在当前数的下边  
                row++; // 行数加一，代表向下移动  
            }
        }

        return false;
    }
}
