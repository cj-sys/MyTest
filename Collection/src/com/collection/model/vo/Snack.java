package com.collection.model.vo;

public class Snack {
		private String flavor;
		private int calorie;
		
		public Snack() {}

		public Snack(String flavor, int calorie) {
			super();
			this.flavor = flavor;
			this.calorie = calorie;
		}
		
		@Override
		public String toString() {
			return flavor + " " + calorie + "cal";
		}
		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + calorie;
			result = prime * result + ((flavor == null) ? 0 : flavor.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (!(obj instanceof Snack))
				return false;
			Snack other = (Snack) obj;
			if (calorie != other.calorie)
				return false;
			if (flavor == null) {
				if (other.flavor != null)
					return false;
			} else if (!flavor.equals(other.flavor))
				return false;
			return true;
		}

		public String getFlavor() {
			return flavor;
		}

		public void setFlavor(String flavor) {
			this.flavor = flavor;
		}

		public int getCalorie() {
			return calorie;
		}

		public void setCalorie(int calorie) {
			this.calorie = calorie;
		}
	}

