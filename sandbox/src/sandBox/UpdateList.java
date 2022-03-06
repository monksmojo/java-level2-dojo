package sandBox;

import java.util.List;

public class UpdateList {
    private List<Integer> passedList;

    public UpdateList(List<Integer> passedList) {
        this.passedList = passedList;
    }

    public void updateList(){
        passedList.add(12);
    }
}
