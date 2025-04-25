import NetInfo from '@react-native-community/netinfo';
import axios from 'axios';

const BackgroundTask = async (taskData) => {
  console.log('🟢 Headless task triggered', taskData);

  return new Promise((resolve) => {
    const unsubscribe = NetInfo.addEventListener(async (state) => {
      if (state.isConnected) {
        console.log('✅ Internet connected! Making API call...');

        try {
          const response = await axios.get('https://jsonplaceholder.typicode.com/posts/1');
          console.log('📡 API Response:', response.data);
        } catch (error) {
          console.error('❌ API Error:', error.message);
        }

        unsubscribe();
        resolve(); // Task complete
      }
    });
  });
};

export default BackgroundTask;
