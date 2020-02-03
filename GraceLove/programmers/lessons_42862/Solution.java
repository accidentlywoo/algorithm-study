package programmers.lessons_42862;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        int[] student = new int[n];

        //도둑맞기 전, 여벌옷을 가져오기 전에 student들은 체육복을 하나씩 갖고있으니까 모든 요소수 1로 채워준다.
        for(int i = 0; i < n; i++) {
            student[i] = 1;
        }

        //체육복을 도둑맞은 학생 위치에 체육복개수 -- 해준다.
        for(int i = 0; i < lost.length; i++) {
            student[lost[i] - 1]--;
        }

        //여벌의 체육복을 갖고있는 학생위치에 체육복개수 ++ 해준다
        for(int i = 0; i < reserve.length; i++) {
            student[reserve[i] - 1]++;
        }


        // ---------------------------------------------------------------
        /**
         * 여기서부터 예외처리. 양끝쪽학생은 0+1번학생 또는 n-2번 학생에게 체육복을 빌려야한다.
         */

        //0번학생이 0개의 체육복을 가지고있으면, 1번학생에게 빌린다. 단, 1번학생이 체육복을 1개 초과로 갖고있을 때만.
        if(student[0] == 0) {
            if(student[1] > 1) {
                student[0]++;
                student[1]--;
            }
        }

        //n-1번학생이 0개의 체육복을 가지고있으면, n-2번학생에게 빌린다. 단, n-2번학생이 체육복을 1개 초과로 갖고있을 때만.
        if(student[n-1] == 0) {
            if(student[n-2] > 1) {
                student[n-1]++;
                student[n-2]--;
            }
        }

        // -----------------------------------------------------------------------------------
        /**
         * for문돌며 인접한 학생에게 체육복을 빌린다.
         */

        // i번째 학생이 체육복이 0개있으면, 인접한 i-1번 학생, 또는 i+1번 학생에게 체육복을 빌린다.
        for(int i = 1; i < student.length - 1; i++) {
            if(student[i] == 0) {
                if(student[i-1] > 1) {
                    student[i]++;
                    student[i-1]--;
                }else if(student[i+1] > 1) {
                    student[i]++;
                    student[i+1]--;
                }
            }
        }

        //결과. student를 돌며 체육복을 0개 초과로 갖고있는 학생을 count한다.
        for(int i = 0; i < student.length; i++) {
            if(student[i] > 0) {
                count++;
            }
        }

        return count;
    }
}
