import java.util.Arrays;

public class HugeInteger {
    private int[] value = new int[40];
    private boolean isPositive = true;

    public void parse(String number) {
        validate(number);
        if (number.charAt(0) == '-') {
            number = number.replace("-", "");
            isPositive = false;
        }
        int length = number.length() - 1;
        for (int i = value.length - 1; i >= 0; i--) {
            value[i] = number.charAt(length) - '0';
            if (length == 0) break;
            length--;
        }
    }

    @Override
    public String toString() {
        String result = "";
        int count = 0;
        for (count = 0; count < value.length; count++) {
            if (value[count] != 0) break;
        }
        for (; count < value.length; count++) {
            if (count == value.length - 1) {
                result += value[count];
                break;
            }
            result += value[count];
        }
        return result;
    }

    public int[] getValue() {
        return value;
    }

    public String add(HugeInteger integer2) {
        String answer = "";
        if (isPositive && integer2.isPositive) {
            return getAnswerForAddition(integer2);
        } else if (this.isPositive && !integer2.isPositive) {
            integer2.isPositive = true;
            return subtract(integer2);
        } else if (!this.isPositive && !integer2.isPositive) {
            this.isPositive = true;
            integer2.isPositive = true;
            answer = "-" + add(integer2);
        } else if (!this.isPositive && integer2.isPositive) {
            this.isPositive = true;
            String result = subtract(integer2);
            if (result.charAt(0) == '-') answer = result.replace("-", "");
            else answer = "-" + result;
        }
        if (answer.isBlank()) return "0";
        return answer;
    }

    private String getAnswerForAddition(HugeInteger integer2) {
        String answer;
        int[] temp = value;
        int[] value1 = integer2.getValue();
        int[] result = new int[40];
        int check = 0;
        for (int i = value.length - 1; i >= 0; i--) {
            result[i] = value[i] + value1[i] + check;
            check = 0;
            if (result[i] > 9) {
                int temp1 = result[i];
                result[i] = result[i] % 10;
                check = temp1 / 10;
            }

        }
        value = result;
        answer = toString();
        value = temp;
        return answer;
    }

    private void validate(String numbers) {
        if(numbers.length() < 1)throw new IllegalArgumentException("Invalid input");
        if(numbers.charAt(0)=='-' ) numbers = numbers.replace("-","");
        if (numbers.length() > 40 || numbers.isBlank() ) throw new IllegalArgumentException("Invalid input");
        for (int count = 0; count < numbers.length(); count++) {
            if (!checkNumber(numbers.charAt(count)))
                throw new IllegalArgumentException("Invalid Input Digit Needed Only");
        }
    }

    private boolean checkNumber(char number) {
        int[] checker = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        boolean condition = false;
        for (int count = 0; count < checker.length; count++) {
            if (number - '0' == checker[count] || number == '-') {
                condition = true;
                break;
            }
        }
        return condition;
    }

    public String subtract(HugeInteger integer2) {
        if (this.isPositive && integer2.isPositive) {
            return getAnswerForSubtraction(integer2);
        } else if (this.isPositive && !integer2.isPositive) {
            integer2.isPositive = true;
            return add(integer2);
        } else if (!this.isPositive && !integer2.isPositive) {
            integer2.isPositive = true;
            this.isPositive = true;
            String result = subtract(integer2);
            if (result.charAt(0) == '-') return result.replace("-", "");
            if (result.equals("0")) return result;
            return "-" + result;
        } else if (!this.isPositive && integer2.isPositive) {
            integer2.isPositive = false;
            return add(integer2);
        }
        return "";
    }

    private String getAnswerForSubtraction(HugeInteger integer2) {
        int[] array = array(integer2.getValue());
        int[] array1 = array(value);
        int[] temp = Arrays.copyOf(value, value.length);
        String answer = "";
        if (array1.length > array.length) {
            checkWhichValueIsGreater1(array1, array);
            answer = toString();
        } else if (array.length > array1.length) {
            checkWhichValueIsGreater2(array1, array);
            answer = "-" + toString();
        } else answer = checkIfLengthIsEqual(array1, array);
        if (answer.isBlank()) answer = "0";
        value = temp;
        return answer;
    }

    private void checkWhichValueIsGreater1(int[] array1, int[] array) {
        array = array1(array1.length, array);
        int[] result = new int[array.length];
        int borrow = 0;
        for (int count = array.length - 1; count >= 0; count--) {
            result[count] = array1[count] - array[count] - borrow;
            borrow = 0;
            if (result[count] < 0) {
                result[count] = result[count] + 10;
                borrow = 1;
            }
        }
        value = Arrays.copyOf(result, result.length);
    }

    private void checkWhichValueIsGreater2(int[] array1, int[] array) {
        array1 = array1(array.length, array1);
        int[] result = new int[array.length];
        int borrow = 0;
        for (int count = array1.length - 1; count >= 0; count--) {
            result[count] = array[count] - array1[count] - borrow;
            borrow = 0;
            if (result[count] < 0) {
                result[count] = result[count] + 10;
                borrow = 1;
            }
        }
        value = Arrays.copyOf(result, result.length);
    }

    private String checkIfLengthIsEqual(int[] array1, int[] array) {
        String result = "";
        if (array1.length == array.length) {
            if (array1[0] > array[0]) {
                checkWhichValueIsGreater1(array1, array);
                result = toString();
            } else if (array[0] > array1[0]) {
                checkWhichValueIsGreater2(array1, array);
                result = "-" + toString();
            } else {
                for (int count = 1; count < array.length; count++) {
                    if (array1[count] > array[count]) {
                        checkWhichValueIsGreater1(array1, array);
                        result = toString();
                        break;
                    } else if (array[count] > array1[count]) {
                        checkWhichValueIsGreater2(array1, array);
                        result = "-" + toString();
                        break;
                    }
                }
            }
        }
        return result;
    }

    private int[] array(int[] array) {
        int i;
        for (i = 0; i <= array.length; i++) {
            if (array[i] != 0) break;
        }
        int[] result = new int[40 - i];
        int counter = 0;
        for (; i < array.length; i++) {
            result[counter++] = array[i];
        }
        return result;
    }

    private int[] array1(int length, int[] array) {
        int[] array2 = new int[length];
        int counter = array2.length - 1;
        for (int count = array.length - 1; count >= 0; count--) {
            array2[counter--] = array[count];
        }
        return array2;
    }

    public boolean isEquals(HugeInteger integer2) {
        int[] array = array(value);
        boolean condition = false;
        int[] array1 = array(integer2.getValue());
        if (array1.length == array.length) {
            for (int count = 0; count < array.length; count++) {
                if (array[count] == array1[count]) condition = true;
                else {
                    condition = false;
                    break;
                }
            }
        }
        return condition;
    }

    public boolean isNotEquals(HugeInteger integer2) {
        return !isEquals(integer2);
    }

    public boolean isGreaterThan(HugeInteger integer) {
        int[] array1 = array(value);
        boolean condition = false;
        int[] array = array(integer.getValue());
        for (int count = 1; count < array.length; count++) {
            if (array1[count] > array[count]) {
                condition = true;
                break;
            }
        }
        return condition;
    }

    public boolean isLesserThan(HugeInteger integer2) {
        int[] array1 = array(value);
        boolean condition = false;
        int[] array = array(integer2.getValue());
        for (int count = 1; count < array.length; count++) {
            if (array1[count] < array[count]) {
                condition = true;
                break;
            }
        }
        return condition;
    }

    public boolean isLesserThanOrEqualTo(HugeInteger integer2) {
        return isLesserThan(integer2) || isEquals(integer2);
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger integer2) {
        return isGreaterThan(integer2) || isEquals(integer2);
    }
}