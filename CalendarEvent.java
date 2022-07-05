
public class CalendarEvent {
	// create private int variables to store the year, month, day, hour
	// minute, and length in minutes of the Event
	private int year, month, day, hour, minute, length, time24;

	// create a boolean variable to store am or pm
  private boolean am;

	// create a string variable to store the name of the event
  private String name;

	// create a constructor that initializes all fields with
	// user data (paramenters)
	public CalendarEvent(int year, int month, int day, int hour, int minute, int length, boolean am, String name) {
    this.year = year;
    this.month = month;
    this.day = day;
    this.minute = minute;
    this.hour = hour;
    this.length = length;
    this.am = am;
    this.name = name;
    time24 = 0;
	}

	// create a default constructor that sets the date and times
	// to 0, am, and a blank string for the name
	public CalendarEvent() {
    this (0, 0, 0, 0, 0, 0, true, "");
    time24 = 0;
	}

	// create a method that checks if two events are at the same
	// date and time, return true if they are. Events are
	// considered at the same time if one starts before another
	// one ends. Events will always be in the same month & year.
	// All events will be less than 24 hours.
	public boolean atSameTime(CalendarEvent e) {
		if ((totalTime() < e.totalTime() && (totalTime() + length) < e.totalTime()) || (e.totalTime() < totalTime() && (e.totalTime() + e.getLength()) < totalTime())) {
      return false;
    }
    return true;
  }
    
  public int totalTime() {
    return (getYear() - 1) * 518400 + (getMonth() - 1) * 43200 + (getDay() - 1) * 1440 + time24 * 60 + getMinute();
  }

	// create a to string method that prints the event in a
	// clean format
	public String toString() {
		String amPm = "";
    if (am) {
      amPm = "AM";
    }
    else {
      amPm = "PM";
    }
    String zero = "";
    if (minute < 10) {
      zero = "0";
    }
    return getName() + ": " + getMonth() + "-" + getDay() + "-" + getYear() + " at " + getHour() + ":" + zero + getMinute() + " " + amPm + " for " +  length + " minutes ";

	}

	// create setters and getters for ALL fields
	public void setYear(int year) {
    this.year = year;
    totalTime();
	}

	public void setMonth(int month) {
    this.month = month;
    totalTime();
	}

	public void setDay(int day) {
    this.day = day;
    totalTime();
	}

	public void setHour(int hour) {
    this.hour = hour;
    if (am) {
      time24 = hour % 12;
    }
    else {
      time24 = (hour % 12) + 12;
    }
    totalTime();
	}

	public void setMinute(int minute) {
    this.minute = minute;
    totalTime();
	}

	public void setLength(int length) {
    this.length = length;
    totalTime();
	}

	public void setAM(boolean am) {
    this.am = am;
    setHour(getHour());
    totalTime();
	}

	public void setName(String name) {
    this.name = name;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getHour() {
    if (am) {
      time24 = hour % 12;
    }
    else {
      time24 = (hour % 12) + 12;
    }
    return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getLength() {
		return length;
	}

	public boolean getAM() { // returns true if the event is in an AM hour
		return am;
	}

	public String getName() {
		return name;
	}
}