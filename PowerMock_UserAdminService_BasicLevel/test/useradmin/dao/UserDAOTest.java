package useradmin.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.legacy.PowerMockRunner;

import useradmin.dto.User;
import useradmin.util.IdGenerator;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(IdGenerator.class)
public class UserDAOTest {

	@Test
	public void creatingusertest() {
		UserDAO dao = new UserDAO();
		mockStatic(IdGenerator.class);
		when(IdGenerator.IDgenerator()).thenReturn(1);
		int idcreated = dao.Create(new User());
		assertEquals(1, idcreated);
		verifyStatic();
	}
}
