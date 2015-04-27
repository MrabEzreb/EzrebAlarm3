import org.junit.Test
import com.ezrebclan.ezrebalarm.alarm.Alarm
import com.ezrebclan.ezrebalarm.alarm.PopupAlert
import java.io.File
import com.ezrebclan.ezrebalarm.dataTypes.Time

class PopupAlertTest {

  @Test
  def test(): Unit = {
    var alarm = new Alarm(new Time(0,0,0)) with PopupAlert {
      popupDescriptor = new File("data/popupWindows/2.xml")
    }
    alarm.goOff()
  }
}