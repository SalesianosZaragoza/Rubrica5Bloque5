package AuthorsBooks.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;

import AuthorsBooks.model.Author;

@Repository
public class AuthorRepository {

	private List<Author> authors = new ArrayList<Author>();

	public void insert(Author authorForm) {
		authors.add(authorForm);
	}

	public List<Author> getAuthors(String searchBy, String val) {
		if (searchBy.equals("name")) {
			Collections.sort(authors, new Comparator<Author>() {
				public int compare(final Author object1, final Author object2) {
					return object1.getName().compareTo(object2.getName());
				}
			});
			int first = -1;
			for (int i = 0; i < authors.size(); i++) {
				if (authors.get(i) != null && authors.get(i).getName().equals(val)) {
					first = i;
					break;
				}
			}
			int last = -1;
			for (int i = authors.size() - 1; i >= 0; i--) {
				if (authors.get(i) != null && authors.get(i).getName().equals(val)) {
					last = i;
					break;
				}
			}
			return authors.subList(first, last);
		} else if (searchBy.equals("born")) {
			Collections.sort(authors, new Comparator<Author>() {
				public int compare(final Author object1, final Author object2) {
					return object1.getBorn().compareTo(object2.getBorn());
				}
			});
			int first = -1;
			for (int i = 0; i < authors.size(); i++) {
				if (authors.get(i) != null && authors.get(i).getBorn().equals(val)) {
					first = i;
					break;
				}
			}
			int last = -1;
			for (int i = authors.size() - 1; i >= 0; i--) {
				if (authors.get(i) != null && authors.get(i).getBorn().equals(val)) {
					last = i;
					break;
				}
			}
			return authors.subList(first, last);
		}
		return null;
	}
}