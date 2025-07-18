import { useEffect, useState } from 'react'; 
import './App.css';

function App() {
  const [athleteData, setAthleteData] = useState(null);
  const [activitiesData, setActivitiesData] = useState(null);
  const [activityData, setActivityData] = useState(null);

  useEffect(() => {
    const fetchAthlete = async () => {
      try {
        const response = await fetch('/api/athlete');
        if (!response.ok) {
          const errorText = await response.text();
          throw new Error(`HTTP ${response.status} - ${errorText}`);
        }
        const result = await response.json();
        setAthleteData(result);
      } catch (error) {
        console.error('Error fetching athlete:', error);
      }
    };

    const fetchActivities = async () => {
      try {
        const response = await fetch('/api/athlete/activities');
        if (!response.ok) {
          const errorText = await response.text();
          throw new Error(`HTTP ${response.status} - ${errorText}`);
        }
        const result = await response.json();
        setActivitiesData(result);
      } catch (error) {
        console.error('Error fetching activities:', error);
      }
    };

    const fetchActivity = async (id) => {
      try {
        const response = await fetch('/api/activities/' + id);
        if (!response.ok) {
          const errorText = await response.text();
          throw new Error(`HTTP ${response.status} - ${errorText}`);
        }
        const result = await response.json();
        setActivityData(result);
      } catch (error) {
        console.error('Error fetching activity:', error);
        throw error;
      }
    };

    fetchActivity("15156812321");
    fetchAthlete();
    fetchActivities();
  }, []);

  return (
    <>
      <div id="activities" className='bottomSection'>
        {activityData ? (
          <pre>{JSON.stringify(activityData, null, 2)}</pre>
        ) : (
          <p>Loading activities...</p>
        )}
      </div>
    </>
  );
}

export default App;
