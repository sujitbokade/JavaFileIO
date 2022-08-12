import java.io.IOException;
import java.util.List;

public class EmployeePayrollService {
    List<EmployeePayrollData> employeePayrollData;

    public EmployeePayrollService(List<EmployeePayrollData> list) {
        this.employeePayrollData = list;
    }

    public enum IOService{
        FILE_IO,CONSOLE_IO
    }

    Boolean writeEmployeePayrollData(IOService ioService){
        PayrollService payrollService = getEmployeePayrollObject(ioService);
        try {
            return payrollService.writePayrollData(employeePayrollData);
        } catch (IOException e) {
            System.out.println("Catch block");
        }
        return false;
    }

    void readEmployeePayrollData(IOService ioService){
        PayrollService payrollService = getEmployeePayrollObject(ioService);
        try {
            payrollService.readPayrollData();
        } catch (IOException e) {
            System.out.println("Catch block");
        }
    }

    long countEmployeePayrollData(IOService ioService){
        PayrollService payrollService = getEmployeePayrollObject(ioService);
        try {
            return payrollService.countEntries();
        } catch (IOException e) {
            System.out.println("Catch block");
        }
        return 0;
    }
    private PayrollService getEmployeePayrollObject(IOService ioService){
        PayrollService payrollService = null;
        if(IOService.FILE_IO.equals(ioService)){
            payrollService = new FileIOServiceImpl();
        }
        else if(IOService.CONSOLE_IO.equals(ioService)){
            payrollService = new ConsoleIOServiceImpl();
        }
        return payrollService;

    }
}
