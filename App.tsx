import React from 'react';
import { View, Button, Text, StyleSheet, NativeModules } from 'react-native';

const { MyBackgroundModule } = NativeModules;

export default function App() {
  const startTask = () => {
    MyBackgroundModule.startBackgroundTask();
  };

  return (
    <View style={styles.container}>
      <Text style={styles.title}>React Native Background Task</Text>
      <Button title="Trigger Background Task" onPress={startTask} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, justifyContent: 'center', alignItems: 'center' },
  title: { fontSize: 18, marginBottom: 16 },
});
