package accomodationsystem;

public class Lease {

        /* ATTRIBUTES */
	private int duration;
	private int leaseNumber;
	private Student student;
        
        /* CONSTRUCTOR */
	public Lease(Student student, int duration, int leaseNumber) {
            this.student = student;
            this.duration = duration;
            this.leaseNumber = leaseNumber;
	}

	public void setDuration(int duration) {
            this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}

	public int getLeaseNumber() {
		return leaseNumber;
	}

	public Student getStudent() {
		return student;
	}

    @Override
    public String toString() {
        return getStudent() + " " + getLeaseNumber() + " " + getDuration();
    }
        
        
}
