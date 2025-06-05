package  lab9.cscd211comparators;
import java.util.Comparator;
import lab9.cscd211classes.Team;
import lab9.cscd211classes.players.*;

public class TeamPayrollComparator implements Comparator<Team>{

    public TeamPayrollComparator(){};

    @Override
    public int compare(Team t1, Team t2) {
        return Integer.compare(t1.calculatePayroll(), t2.calculatePayroll());
    }
}
