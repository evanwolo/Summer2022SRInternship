My program maps the json data to Team objects containing a HashMap<String, Integer> representing
the opposing team and its own win value against said opposing team. Team objects are then mapped to rows
which compare the opposing name team to the generated header to align win values to their proper teams.
These rows are added to the overall matrix which represents the Win-Loss record table. A toString() method
was generated for testing and visualization purposes.