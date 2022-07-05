class Calendar {
	// create an array of CalendarEvent objects that can hold  
	// ten events
  private CalendarEvent[] arr = new CalendarEvent[10];

	// create an addEvent method that attempts to add a
	// CalendarEvent to the array. If you successfully add an  
	// event to the array return true, otherwise if an event 
	// already overlaps with that time or if the array is full, 
	// return false.
	public boolean addEvent (CalendarEvent e) {
    int pos = 0;
    for (int idx = 0; idx < arr.length; idx++) {
      if (arr[idx] != null && arr[idx].atSameTime(e)) {
        return false;
      }
      if (arr[idx] != null) {
        pos = idx;
      }
    }
    if (pos < 8) {
      arr[pos + 1] = e;
      return true;
    }
    return false;
  }

	// create a getEventByName that returns the first date with 
	// the same name, regarless of case, otherwise it returns 
	// null.
	public CalendarEvent getEventByName (String name) {
		for(int idx = 0; idx < arr.length; idx++) {
      if(arr[idx] != null && arr[idx].getName().toLowerCase().equals(name.toLowerCase())) {
        return arr[idx];
      }
    }
    return null;
	}

	// create a removeEvent method that deletes an event from 
	// the array if the event has the same name, and date and 
	// time. Return the removed event if found, otherwise 
	// return null. The method should shift the array to 
	// prevent any null's apearing in the middle of the calendar.
	public CalendarEvent removeEvent (CalendarEvent e) {
		int pos = -1;
    for(int idx = 0; idx < arr.length && pos == -1; idx++) {
      if (arr[idx] == e) {
        pos = idx;
        arr[idx] = null;
      }
    }
    if (pos == -1) {
      return null;
    }
    for (int idx = pos; idx < arr.length - 1; idx++) {
      arr[idx] = arr[idx + 1];
    }
    return e;
	}

	// create a checkDate method that returns true if any event 
	// is on that date, otherwise it returns false
	public boolean checkDate (int year, int month, int day) {
    for (int idx = 0; idx < arr.length; idx++) {
     if (arr[idx] != null && arr[idx].getYear() == year && arr[idx].getMonth() == month && arr[idx].getDay() == day)  {
        return true;
      }
    }
		return false;
	}

	// create a method printDay that prints all events on a 
	// given date
	public void printDay (int year, int month, int day) {
    for(int idx = 0; idx < arr.length; idx++) {
      if (arr[idx] != null && arr[idx].getYear() == year && arr[idx].getMonth() == month && arr[idx].getDay() == day) {
        System.out.println(arr[idx]);
      }
    }
  }
	

	// create a toString method that prints all of the events in 
	// the calendar
	public String toString () {
    String str = "";
    for (int idx = 0; idx < arr.length; idx++) {
      str += arr[idx] + "\n";
    }
    return str;
	}
}